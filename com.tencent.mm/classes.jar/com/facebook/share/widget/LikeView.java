package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.d;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.R.styleable;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.share.internal.LikeButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeView
  extends FrameLayout
{
  private static final int NO_FOREGROUND_COLOR = -1;
  private LikeView.AuxiliaryViewPosition auxiliaryViewPosition;
  private BroadcastReceiver broadcastReceiver;
  private LinearLayout containerView;
  private LikeView.LikeActionControllerCreationCallback creationCallback;
  private int edgePadding;
  private boolean explicitlyDisabled;
  private int foregroundColor;
  private LikeView.HorizontalAlignment horizontalAlignment;
  private int internalPadding;
  private LikeActionController likeActionController;
  private LikeBoxCountView likeBoxCountView;
  private LikeButton likeButton;
  private LikeView.Style likeViewStyle;
  private String objectId;
  private LikeView.ObjectType objectType;
  private OnErrorListener onErrorListener;
  private FragmentWrapper parentFragment;
  private TextView socialSentenceView;
  
  @Deprecated
  public LikeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97647);
    this.likeViewStyle = LikeView.Style.DEFAULT;
    this.horizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
    this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
    this.foregroundColor = -1;
    this.explicitlyDisabled = true;
    initialize(paramContext);
    AppMethodBeat.o(97647);
  }
  
  @Deprecated
  public LikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97648);
    this.likeViewStyle = LikeView.Style.DEFAULT;
    this.horizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
    this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
    this.foregroundColor = -1;
    this.explicitlyDisabled = true;
    parseAttributes(paramAttributeSet);
    initialize(paramContext);
    AppMethodBeat.o(97648);
  }
  
  private void associateWithLikeActionController(LikeActionController paramLikeActionController)
  {
    AppMethodBeat.i(97667);
    this.likeActionController = paramLikeActionController;
    this.broadcastReceiver = new LikeView.LikeControllerBroadcastReceiver(this, null);
    paramLikeActionController = d.R(getContext());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
    paramLikeActionController.a(this.broadcastReceiver, localIntentFilter);
    AppMethodBeat.o(97667);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(97664);
    for (Object localObject = getContext(); (!(localObject instanceof Activity)) && ((localObject instanceof ContextWrapper)); localObject = ((ContextWrapper)localObject).getBaseContext()) {}
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      AppMethodBeat.o(97664);
      return localObject;
    }
    localObject = new FacebookException("Unable to get Activity.");
    AppMethodBeat.o(97664);
    throw ((Throwable)localObject);
  }
  
  private Bundle getAnalyticsParameters()
  {
    AppMethodBeat.i(97665);
    Bundle localBundle = new Bundle();
    localBundle.putString("style", this.likeViewStyle.toString());
    localBundle.putString("auxiliary_position", this.auxiliaryViewPosition.toString());
    localBundle.putString("horizontal_alignment", this.horizontalAlignment.toString());
    localBundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
    localBundle.putString("object_type", this.objectType.toString());
    AppMethodBeat.o(97665);
    return localBundle;
  }
  
  private void initialize(Context paramContext)
  {
    AppMethodBeat.i(97659);
    this.edgePadding = getResources().getDimensionPixelSize(2131428246);
    this.internalPadding = getResources().getDimensionPixelSize(2131428247);
    if (this.foregroundColor == -1) {
      this.foregroundColor = getResources().getColor(2131689907);
    }
    setBackgroundColor(0);
    this.containerView = new LinearLayout(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.containerView.setLayoutParams(localLayoutParams);
    initializeLikeButton(paramContext);
    initializeSocialSentenceView(paramContext);
    initializeLikeCountView(paramContext);
    this.containerView.addView(this.likeButton);
    this.containerView.addView(this.socialSentenceView);
    this.containerView.addView(this.likeBoxCountView);
    addView(this.containerView);
    setObjectIdAndTypeForced(this.objectId, this.objectType);
    updateLikeStateAndLayout();
    AppMethodBeat.o(97659);
  }
  
  private void initializeLikeButton(Context paramContext)
  {
    AppMethodBeat.i(97660);
    if ((this.likeActionController != null) && (this.likeActionController.isObjectLiked())) {}
    for (boolean bool = true;; bool = false)
    {
      this.likeButton = new LikeButton(paramContext, bool);
      this.likeButton.setOnClickListener(new LikeView.1(this));
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      this.likeButton.setLayoutParams(paramContext);
      AppMethodBeat.o(97660);
      return;
    }
  }
  
  private void initializeLikeCountView(Context paramContext)
  {
    AppMethodBeat.i(97662);
    this.likeBoxCountView = new LikeBoxCountView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.likeBoxCountView.setLayoutParams(paramContext);
    AppMethodBeat.o(97662);
  }
  
  private void initializeSocialSentenceView(Context paramContext)
  {
    AppMethodBeat.i(97661);
    this.socialSentenceView = new TextView(paramContext);
    this.socialSentenceView.setTextSize(0, getResources().getDimension(2131428248));
    this.socialSentenceView.setMaxLines(2);
    this.socialSentenceView.setTextColor(this.foregroundColor);
    this.socialSentenceView.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-2, -1);
    this.socialSentenceView.setLayoutParams(paramContext);
    AppMethodBeat.o(97661);
  }
  
  private void parseAttributes(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(97658);
    if ((paramAttributeSet == null) || (getContext() == null))
    {
      AppMethodBeat.o(97658);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_like_view);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(97658);
      return;
    }
    this.objectId = Utility.coerceValueIfNullOrEmpty(paramAttributeSet.getString(1), null);
    this.objectType = LikeView.ObjectType.fromInt(paramAttributeSet.getInt(2, LikeView.ObjectType.DEFAULT.getValue()));
    this.likeViewStyle = LikeView.Style.fromInt(paramAttributeSet.getInt(3, LikeView.Style.access$000(LikeView.Style.DEFAULT)));
    if (this.likeViewStyle == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'style'");
      AppMethodBeat.o(97658);
      throw paramAttributeSet;
    }
    this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.fromInt(paramAttributeSet.getInt(4, LikeView.AuxiliaryViewPosition.access$100(LikeView.AuxiliaryViewPosition.DEFAULT)));
    if (this.auxiliaryViewPosition == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
      AppMethodBeat.o(97658);
      throw paramAttributeSet;
    }
    this.horizontalAlignment = LikeView.HorizontalAlignment.fromInt(paramAttributeSet.getInt(5, LikeView.HorizontalAlignment.access$200(LikeView.HorizontalAlignment.DEFAULT)));
    if (this.horizontalAlignment == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
      AppMethodBeat.o(97658);
      throw paramAttributeSet;
    }
    this.foregroundColor = paramAttributeSet.getColor(0, -1);
    paramAttributeSet.recycle();
    AppMethodBeat.o(97658);
  }
  
  private void setObjectIdAndTypeForced(String paramString, LikeView.ObjectType paramObjectType)
  {
    AppMethodBeat.i(97666);
    tearDownObjectAssociations();
    this.objectId = paramString;
    this.objectType = paramObjectType;
    if (Utility.isNullOrEmpty(paramString))
    {
      AppMethodBeat.o(97666);
      return;
    }
    this.creationCallback = new LikeView.LikeActionControllerCreationCallback(this, null);
    if (!isInEditMode()) {
      LikeActionController.getControllerForObjectId(paramString, paramObjectType, this.creationCallback);
    }
    AppMethodBeat.o(97666);
  }
  
  private void tearDownObjectAssociations()
  {
    AppMethodBeat.i(97668);
    if (this.broadcastReceiver != null)
    {
      d.R(getContext()).unregisterReceiver(this.broadcastReceiver);
      this.broadcastReceiver = null;
    }
    if (this.creationCallback != null)
    {
      this.creationCallback.cancel();
      this.creationCallback = null;
    }
    this.likeActionController = null;
    AppMethodBeat.o(97668);
  }
  
  private void toggleLike()
  {
    AppMethodBeat.i(97663);
    if (this.likeActionController != null)
    {
      Activity localActivity = null;
      if (this.parentFragment == null) {
        localActivity = getActivity();
      }
      this.likeActionController.toggleLike(localActivity, this.parentFragment, getAnalyticsParameters());
    }
    AppMethodBeat.o(97663);
  }
  
  private void updateBoxCountCaretPosition()
  {
    AppMethodBeat.i(97671);
    LikeBoxCountView localLikeBoxCountView;
    LikeBoxCountView.LikeBoxCountViewCaretPosition localLikeBoxCountViewCaretPosition;
    switch (LikeView.2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
    {
    default: 
      AppMethodBeat.o(97671);
      return;
    case 1: 
      localLikeBoxCountView = this.likeBoxCountView;
      localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM;
    }
    for (;;)
    {
      localLikeBoxCountView.setCaretPosition(localLikeBoxCountViewCaretPosition);
      break;
      localLikeBoxCountView = this.likeBoxCountView;
      localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP;
      continue;
      localLikeBoxCountView = this.likeBoxCountView;
      if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT) {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT;
      } else {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
      }
    }
  }
  
  private void updateLayout()
  {
    int j = 1;
    AppMethodBeat.i(97670);
    Object localObject1 = (FrameLayout.LayoutParams)this.containerView.getLayoutParams();
    Object localObject2 = (LinearLayout.LayoutParams)this.likeButton.getLayoutParams();
    int i;
    if (this.horizontalAlignment == LikeView.HorizontalAlignment.LEFT)
    {
      i = 3;
      ((FrameLayout.LayoutParams)localObject1).gravity = (i | 0x30);
      ((LinearLayout.LayoutParams)localObject2).gravity = i;
      this.socialSentenceView.setVisibility(8);
      this.likeBoxCountView.setVisibility(8);
      if ((this.likeViewStyle != LikeView.Style.STANDARD) || (this.likeActionController == null) || (Utility.isNullOrEmpty(this.likeActionController.getSocialSentence()))) {
        break label267;
      }
      localObject1 = this.socialSentenceView;
      label110:
      ((View)localObject1).setVisibility(0);
      ((LinearLayout.LayoutParams)((View)localObject1).getLayoutParams()).gravity = i;
      localObject2 = this.containerView;
      i = j;
      if (this.auxiliaryViewPosition == LikeView.AuxiliaryViewPosition.INLINE) {
        i = 0;
      }
      ((LinearLayout)localObject2).setOrientation(i);
      if ((this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.TOP) && ((this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.INLINE) || (this.horizontalAlignment != LikeView.HorizontalAlignment.RIGHT))) {
        break label316;
      }
      this.containerView.removeView(this.likeButton);
      this.containerView.addView(this.likeButton);
      label204:
      switch (LikeView.2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(97670);
      return;
      if (this.horizontalAlignment == LikeView.HorizontalAlignment.CENTER)
      {
        i = 1;
        break;
      }
      i = 5;
      break;
      label267:
      if ((this.likeViewStyle == LikeView.Style.BOX_COUNT) && (this.likeActionController != null) && (!Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())))
      {
        updateBoxCountCaretPosition();
        localObject1 = this.likeBoxCountView;
        break label110;
      }
      AppMethodBeat.o(97670);
      return;
      label316:
      this.containerView.removeView((View)localObject1);
      this.containerView.addView((View)localObject1);
      break label204;
      ((View)localObject1).setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
      AppMethodBeat.o(97670);
      return;
      ((View)localObject1).setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
      AppMethodBeat.o(97670);
      return;
      if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT)
      {
        ((View)localObject1).setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
        AppMethodBeat.o(97670);
        return;
      }
      ((View)localObject1).setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
    }
  }
  
  private void updateLikeStateAndLayout()
  {
    AppMethodBeat.i(97669);
    boolean bool;
    if (!this.explicitlyDisabled)
    {
      bool = true;
      if (this.likeActionController != null) {
        break label75;
      }
      this.likeButton.setSelected(false);
      this.socialSentenceView.setText(null);
      this.likeBoxCountView.setText(null);
    }
    for (;;)
    {
      super.setEnabled(bool);
      this.likeButton.setEnabled(bool);
      updateLayout();
      AppMethodBeat.o(97669);
      return;
      bool = false;
      break;
      label75:
      this.likeButton.setSelected(this.likeActionController.isObjectLiked());
      this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
      this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
      bool &= this.likeActionController.shouldEnableView();
    }
  }
  
  @Deprecated
  public OnErrorListener getOnErrorListener()
  {
    return this.onErrorListener;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97657);
    setObjectIdAndType(null, LikeView.ObjectType.UNKNOWN);
    super.onDetachedFromWindow();
    AppMethodBeat.o(97657);
  }
  
  @Deprecated
  public void setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition paramAuxiliaryViewPosition)
  {
    AppMethodBeat.i(97651);
    if (paramAuxiliaryViewPosition != null) {}
    for (;;)
    {
      if (this.auxiliaryViewPosition != paramAuxiliaryViewPosition)
      {
        this.auxiliaryViewPosition = paramAuxiliaryViewPosition;
        updateLayout();
      }
      AppMethodBeat.o(97651);
      return;
      paramAuxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
    }
  }
  
  @Deprecated
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97656);
    this.explicitlyDisabled = true;
    updateLikeStateAndLayout();
    AppMethodBeat.o(97656);
  }
  
  @Deprecated
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(97653);
    if (this.foregroundColor != paramInt) {
      this.socialSentenceView.setTextColor(paramInt);
    }
    AppMethodBeat.o(97653);
  }
  
  @Deprecated
  public void setFragment(android.app.Fragment paramFragment)
  {
    AppMethodBeat.i(97655);
    this.parentFragment = new FragmentWrapper(paramFragment);
    AppMethodBeat.o(97655);
  }
  
  @Deprecated
  public void setFragment(android.support.v4.app.Fragment paramFragment)
  {
    AppMethodBeat.i(97654);
    this.parentFragment = new FragmentWrapper(paramFragment);
    AppMethodBeat.o(97654);
  }
  
  @Deprecated
  public void setHorizontalAlignment(LikeView.HorizontalAlignment paramHorizontalAlignment)
  {
    AppMethodBeat.i(97652);
    if (paramHorizontalAlignment != null) {}
    for (;;)
    {
      if (this.horizontalAlignment != paramHorizontalAlignment)
      {
        this.horizontalAlignment = paramHorizontalAlignment;
        updateLayout();
      }
      AppMethodBeat.o(97652);
      return;
      paramHorizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
    }
  }
  
  @Deprecated
  public void setLikeViewStyle(LikeView.Style paramStyle)
  {
    AppMethodBeat.i(97650);
    if (paramStyle != null) {}
    for (;;)
    {
      if (this.likeViewStyle != paramStyle)
      {
        this.likeViewStyle = paramStyle;
        updateLayout();
      }
      AppMethodBeat.o(97650);
      return;
      paramStyle = LikeView.Style.DEFAULT;
    }
  }
  
  @Deprecated
  public void setObjectIdAndType(String paramString, LikeView.ObjectType paramObjectType)
  {
    AppMethodBeat.i(97649);
    paramString = Utility.coerceValueIfNullOrEmpty(paramString, null);
    if (paramObjectType != null) {}
    for (;;)
    {
      if ((!Utility.areObjectsEqual(paramString, this.objectId)) || (paramObjectType != this.objectType))
      {
        setObjectIdAndTypeForced(paramString, paramObjectType);
        updateLikeStateAndLayout();
      }
      AppMethodBeat.o(97649);
      return;
      paramObjectType = LikeView.ObjectType.DEFAULT;
    }
  }
  
  @Deprecated
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.widget.LikeView
 * JD-Core Version:    0.7.0.1
 */