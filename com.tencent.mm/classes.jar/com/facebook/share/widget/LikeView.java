package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.R.styleable;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeActionController.CreationCallback;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.share.internal.LikeButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeView
  extends FrameLayout
{
  private static final int NO_FOREGROUND_COLOR = -1;
  private AuxiliaryViewPosition auxiliaryViewPosition;
  private BroadcastReceiver broadcastReceiver;
  private LinearLayout containerView;
  private LikeActionControllerCreationCallback creationCallback;
  private int edgePadding;
  private boolean explicitlyDisabled;
  private int foregroundColor;
  private HorizontalAlignment horizontalAlignment;
  private int internalPadding;
  private LikeActionController likeActionController;
  private LikeBoxCountView likeBoxCountView;
  private LikeButton likeButton;
  private Style likeViewStyle;
  private String objectId;
  private ObjectType objectType;
  private OnErrorListener onErrorListener;
  private FragmentWrapper parentFragment;
  private TextView socialSentenceView;
  
  @Deprecated
  public LikeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(8671);
    this.likeViewStyle = Style.DEFAULT;
    this.horizontalAlignment = HorizontalAlignment.DEFAULT;
    this.auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    this.foregroundColor = -1;
    this.explicitlyDisabled = true;
    initialize(paramContext);
    AppMethodBeat.o(8671);
  }
  
  @Deprecated
  public LikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8672);
    this.likeViewStyle = Style.DEFAULT;
    this.horizontalAlignment = HorizontalAlignment.DEFAULT;
    this.auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    this.foregroundColor = -1;
    this.explicitlyDisabled = true;
    parseAttributes(paramAttributeSet);
    initialize(paramContext);
    AppMethodBeat.o(8672);
  }
  
  private void associateWithLikeActionController(LikeActionController paramLikeActionController)
  {
    AppMethodBeat.i(8691);
    this.likeActionController = paramLikeActionController;
    this.broadcastReceiver = new LikeControllerBroadcastReceiver(null);
    paramLikeActionController = d.U(getContext());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
    paramLikeActionController.a(this.broadcastReceiver, localIntentFilter);
    AppMethodBeat.o(8691);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(8688);
    for (Object localObject = getContext(); (!(localObject instanceof Activity)) && ((localObject instanceof ContextWrapper)); localObject = ((ContextWrapper)localObject).getBaseContext()) {}
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      AppMethodBeat.o(8688);
      return localObject;
    }
    localObject = new FacebookException("Unable to get Activity.");
    AppMethodBeat.o(8688);
    throw ((Throwable)localObject);
  }
  
  private Bundle getAnalyticsParameters()
  {
    AppMethodBeat.i(8689);
    Bundle localBundle = new Bundle();
    localBundle.putString("style", this.likeViewStyle.toString());
    localBundle.putString("auxiliary_position", this.auxiliaryViewPosition.toString());
    localBundle.putString("horizontal_alignment", this.horizontalAlignment.toString());
    localBundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
    localBundle.putString("object_type", this.objectType.toString());
    AppMethodBeat.o(8689);
    return localBundle;
  }
  
  private void initialize(Context paramContext)
  {
    AppMethodBeat.i(8683);
    this.edgePadding = getResources().getDimensionPixelSize(2131166059);
    this.internalPadding = getResources().getDimensionPixelSize(2131166060);
    if (this.foregroundColor == -1) {
      this.foregroundColor = getResources().getColor(2131100177);
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
    AppMethodBeat.o(8683);
  }
  
  private void initializeLikeButton(Context paramContext)
  {
    AppMethodBeat.i(8684);
    if ((this.likeActionController != null) && (this.likeActionController.isObjectLiked())) {}
    for (boolean bool = true;; bool = false)
    {
      this.likeButton = new LikeButton(paramContext, bool);
      this.likeButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8648);
          LikeView.access$300(LikeView.this);
          AppMethodBeat.o(8648);
        }
      });
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      this.likeButton.setLayoutParams(paramContext);
      AppMethodBeat.o(8684);
      return;
    }
  }
  
  private void initializeLikeCountView(Context paramContext)
  {
    AppMethodBeat.i(8686);
    this.likeBoxCountView = new LikeBoxCountView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.likeBoxCountView.setLayoutParams(paramContext);
    AppMethodBeat.o(8686);
  }
  
  private void initializeSocialSentenceView(Context paramContext)
  {
    AppMethodBeat.i(8685);
    this.socialSentenceView = new TextView(paramContext);
    this.socialSentenceView.setTextSize(0, getResources().getDimension(2131166061));
    this.socialSentenceView.setMaxLines(2);
    this.socialSentenceView.setTextColor(this.foregroundColor);
    this.socialSentenceView.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-2, -1);
    this.socialSentenceView.setLayoutParams(paramContext);
    AppMethodBeat.o(8685);
  }
  
  private void parseAttributes(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(8682);
    if ((paramAttributeSet == null) || (getContext() == null))
    {
      AppMethodBeat.o(8682);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_like_view);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(8682);
      return;
    }
    this.objectId = Utility.coerceValueIfNullOrEmpty(paramAttributeSet.getString(3), null);
    this.objectType = ObjectType.fromInt(paramAttributeSet.getInt(4, ObjectType.DEFAULT.getValue()));
    this.likeViewStyle = Style.fromInt(paramAttributeSet.getInt(5, Style.access$000(Style.DEFAULT)));
    if (this.likeViewStyle == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'style'");
      AppMethodBeat.o(8682);
      throw paramAttributeSet;
    }
    this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(paramAttributeSet.getInt(0, AuxiliaryViewPosition.access$100(AuxiliaryViewPosition.DEFAULT)));
    if (this.auxiliaryViewPosition == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
      AppMethodBeat.o(8682);
      throw paramAttributeSet;
    }
    this.horizontalAlignment = HorizontalAlignment.fromInt(paramAttributeSet.getInt(2, HorizontalAlignment.access$200(HorizontalAlignment.DEFAULT)));
    if (this.horizontalAlignment == null)
    {
      paramAttributeSet = new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
      AppMethodBeat.o(8682);
      throw paramAttributeSet;
    }
    this.foregroundColor = paramAttributeSet.getColor(1, -1);
    paramAttributeSet.recycle();
    AppMethodBeat.o(8682);
  }
  
  private void setObjectIdAndTypeForced(String paramString, ObjectType paramObjectType)
  {
    AppMethodBeat.i(8690);
    tearDownObjectAssociations();
    this.objectId = paramString;
    this.objectType = paramObjectType;
    if (Utility.isNullOrEmpty(paramString))
    {
      AppMethodBeat.o(8690);
      return;
    }
    this.creationCallback = new LikeActionControllerCreationCallback(null);
    if (!isInEditMode()) {
      LikeActionController.getControllerForObjectId(paramString, paramObjectType, this.creationCallback);
    }
    AppMethodBeat.o(8690);
  }
  
  private void tearDownObjectAssociations()
  {
    AppMethodBeat.i(8692);
    if (this.broadcastReceiver != null)
    {
      d.U(getContext()).unregisterReceiver(this.broadcastReceiver);
      this.broadcastReceiver = null;
    }
    if (this.creationCallback != null)
    {
      this.creationCallback.cancel();
      this.creationCallback = null;
    }
    this.likeActionController = null;
    AppMethodBeat.o(8692);
  }
  
  private void toggleLike()
  {
    AppMethodBeat.i(8687);
    if (this.likeActionController != null)
    {
      Activity localActivity = null;
      if (this.parentFragment == null) {
        localActivity = getActivity();
      }
      this.likeActionController.toggleLike(localActivity, this.parentFragment, getAnalyticsParameters());
    }
    AppMethodBeat.o(8687);
  }
  
  private void updateBoxCountCaretPosition()
  {
    AppMethodBeat.i(8695);
    LikeBoxCountView localLikeBoxCountView;
    LikeBoxCountView.LikeBoxCountViewCaretPosition localLikeBoxCountViewCaretPosition;
    switch (2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
    {
    default: 
      AppMethodBeat.o(8695);
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
      if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT;
      } else {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
      }
    }
  }
  
  private void updateLayout()
  {
    int j = 1;
    AppMethodBeat.i(8694);
    Object localObject1 = (FrameLayout.LayoutParams)this.containerView.getLayoutParams();
    Object localObject2 = (LinearLayout.LayoutParams)this.likeButton.getLayoutParams();
    int i;
    if (this.horizontalAlignment == HorizontalAlignment.LEFT)
    {
      i = 3;
      ((FrameLayout.LayoutParams)localObject1).gravity = (i | 0x30);
      ((LinearLayout.LayoutParams)localObject2).gravity = i;
      this.socialSentenceView.setVisibility(8);
      this.likeBoxCountView.setVisibility(8);
      if ((this.likeViewStyle != Style.STANDARD) || (this.likeActionController == null) || (Utility.isNullOrEmpty(this.likeActionController.getSocialSentence()))) {
        break label267;
      }
      localObject1 = this.socialSentenceView;
      label110:
      ((View)localObject1).setVisibility(0);
      ((LinearLayout.LayoutParams)((View)localObject1).getLayoutParams()).gravity = i;
      localObject2 = this.containerView;
      i = j;
      if (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) {
        i = 0;
      }
      ((LinearLayout)localObject2).setOrientation(i);
      if ((this.auxiliaryViewPosition != AuxiliaryViewPosition.TOP) && ((this.auxiliaryViewPosition != AuxiliaryViewPosition.INLINE) || (this.horizontalAlignment != HorizontalAlignment.RIGHT))) {
        break label316;
      }
      this.containerView.removeView(this.likeButton);
      this.containerView.addView(this.likeButton);
      label204:
      switch (2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(8694);
      return;
      if (this.horizontalAlignment == HorizontalAlignment.CENTER)
      {
        i = 1;
        break;
      }
      i = 5;
      break;
      label267:
      if ((this.likeViewStyle == Style.BOX_COUNT) && (this.likeActionController != null) && (!Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())))
      {
        updateBoxCountCaretPosition();
        localObject1 = this.likeBoxCountView;
        break label110;
      }
      AppMethodBeat.o(8694);
      return;
      label316:
      this.containerView.removeView((View)localObject1);
      this.containerView.addView((View)localObject1);
      break label204;
      ((View)localObject1).setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
      AppMethodBeat.o(8694);
      return;
      ((View)localObject1).setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
      AppMethodBeat.o(8694);
      return;
      if (this.horizontalAlignment == HorizontalAlignment.RIGHT)
      {
        ((View)localObject1).setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
        AppMethodBeat.o(8694);
        return;
      }
      ((View)localObject1).setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
    }
  }
  
  private void updateLikeStateAndLayout()
  {
    AppMethodBeat.i(8693);
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
      AppMethodBeat.o(8693);
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
    AppMethodBeat.i(8681);
    setObjectIdAndType(null, ObjectType.UNKNOWN);
    super.onDetachedFromWindow();
    AppMethodBeat.o(8681);
  }
  
  @Deprecated
  public void setAuxiliaryViewPosition(AuxiliaryViewPosition paramAuxiliaryViewPosition)
  {
    AppMethodBeat.i(8675);
    if (paramAuxiliaryViewPosition != null) {}
    for (;;)
    {
      if (this.auxiliaryViewPosition != paramAuxiliaryViewPosition)
      {
        this.auxiliaryViewPosition = paramAuxiliaryViewPosition;
        updateLayout();
      }
      AppMethodBeat.o(8675);
      return;
      paramAuxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    }
  }
  
  @Deprecated
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(8680);
    this.explicitlyDisabled = true;
    updateLikeStateAndLayout();
    AppMethodBeat.o(8680);
  }
  
  @Deprecated
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(8677);
    if (this.foregroundColor != paramInt) {
      this.socialSentenceView.setTextColor(paramInt);
    }
    AppMethodBeat.o(8677);
  }
  
  @Deprecated
  public void setFragment(android.app.Fragment paramFragment)
  {
    AppMethodBeat.i(8679);
    this.parentFragment = new FragmentWrapper(paramFragment);
    AppMethodBeat.o(8679);
  }
  
  @Deprecated
  public void setFragment(android.support.v4.app.Fragment paramFragment)
  {
    AppMethodBeat.i(8678);
    this.parentFragment = new FragmentWrapper(paramFragment);
    AppMethodBeat.o(8678);
  }
  
  @Deprecated
  public void setHorizontalAlignment(HorizontalAlignment paramHorizontalAlignment)
  {
    AppMethodBeat.i(8676);
    if (paramHorizontalAlignment != null) {}
    for (;;)
    {
      if (this.horizontalAlignment != paramHorizontalAlignment)
      {
        this.horizontalAlignment = paramHorizontalAlignment;
        updateLayout();
      }
      AppMethodBeat.o(8676);
      return;
      paramHorizontalAlignment = HorizontalAlignment.DEFAULT;
    }
  }
  
  @Deprecated
  public void setLikeViewStyle(Style paramStyle)
  {
    AppMethodBeat.i(8674);
    if (paramStyle != null) {}
    for (;;)
    {
      if (this.likeViewStyle != paramStyle)
      {
        this.likeViewStyle = paramStyle;
        updateLayout();
      }
      AppMethodBeat.o(8674);
      return;
      paramStyle = Style.DEFAULT;
    }
  }
  
  @Deprecated
  public void setObjectIdAndType(String paramString, ObjectType paramObjectType)
  {
    AppMethodBeat.i(8673);
    paramString = Utility.coerceValueIfNullOrEmpty(paramString, null);
    if (paramObjectType != null) {}
    for (;;)
    {
      if ((!Utility.areObjectsEqual(paramString, this.objectId)) || (paramObjectType != this.objectType))
      {
        setObjectIdAndTypeForced(paramString, paramObjectType);
        updateLikeStateAndLayout();
      }
      AppMethodBeat.o(8673);
      return;
      paramObjectType = ObjectType.DEFAULT;
    }
  }
  
  @Deprecated
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  @Deprecated
  public static enum AuxiliaryViewPosition
  {
    static AuxiliaryViewPosition DEFAULT;
    private int intValue;
    private String stringValue;
    
    static
    {
      AppMethodBeat.i(8654);
      BOTTOM = new AuxiliaryViewPosition("BOTTOM", 0, "bottom", 0);
      INLINE = new AuxiliaryViewPosition("INLINE", 1, "inline", 1);
      TOP = new AuxiliaryViewPosition("TOP", 2, "top", 2);
      $VALUES = new AuxiliaryViewPosition[] { BOTTOM, INLINE, TOP };
      DEFAULT = BOTTOM;
      AppMethodBeat.o(8654);
    }
    
    private AuxiliaryViewPosition(String paramString, int paramInt)
    {
      this.stringValue = paramString;
      this.intValue = paramInt;
    }
    
    static AuxiliaryViewPosition fromInt(int paramInt)
    {
      AppMethodBeat.i(8652);
      AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = values();
      int j = arrayOfAuxiliaryViewPosition.length;
      int i = 0;
      while (i < j)
      {
        AuxiliaryViewPosition localAuxiliaryViewPosition = arrayOfAuxiliaryViewPosition[i];
        if (localAuxiliaryViewPosition.getValue() == paramInt)
        {
          AppMethodBeat.o(8652);
          return localAuxiliaryViewPosition;
        }
        i += 1;
      }
      AppMethodBeat.o(8652);
      return null;
    }
    
    private int getValue()
    {
      return this.intValue;
    }
    
    public final String toString()
    {
      return this.stringValue;
    }
  }
  
  @Deprecated
  public static enum HorizontalAlignment
  {
    static HorizontalAlignment DEFAULT;
    private int intValue;
    private String stringValue;
    
    static
    {
      AppMethodBeat.i(8659);
      CENTER = new HorizontalAlignment("CENTER", 0, "center", 0);
      LEFT = new HorizontalAlignment("LEFT", 1, "left", 1);
      RIGHT = new HorizontalAlignment("RIGHT", 2, "right", 2);
      $VALUES = new HorizontalAlignment[] { CENTER, LEFT, RIGHT };
      DEFAULT = CENTER;
      AppMethodBeat.o(8659);
    }
    
    private HorizontalAlignment(String paramString, int paramInt)
    {
      this.stringValue = paramString;
      this.intValue = paramInt;
    }
    
    static HorizontalAlignment fromInt(int paramInt)
    {
      AppMethodBeat.i(8657);
      HorizontalAlignment[] arrayOfHorizontalAlignment = values();
      int j = arrayOfHorizontalAlignment.length;
      int i = 0;
      while (i < j)
      {
        HorizontalAlignment localHorizontalAlignment = arrayOfHorizontalAlignment[i];
        if (localHorizontalAlignment.getValue() == paramInt)
        {
          AppMethodBeat.o(8657);
          return localHorizontalAlignment;
        }
        i += 1;
      }
      AppMethodBeat.o(8657);
      return null;
    }
    
    private int getValue()
    {
      return this.intValue;
    }
    
    public final String toString()
    {
      return this.stringValue;
    }
  }
  
  class LikeActionControllerCreationCallback
    implements LikeActionController.CreationCallback
  {
    private boolean isCancelled;
    
    private LikeActionControllerCreationCallback() {}
    
    public void cancel()
    {
      this.isCancelled = true;
    }
    
    public void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException)
    {
      AppMethodBeat.i(8660);
      if (this.isCancelled)
      {
        AppMethodBeat.o(8660);
        return;
      }
      FacebookException localFacebookException = paramFacebookException;
      if (paramLikeActionController != null)
      {
        if (!paramLikeActionController.shouldEnableView()) {
          paramFacebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
        }
        LikeView.access$1100(LikeView.this, paramLikeActionController);
        LikeView.access$700(LikeView.this);
        localFacebookException = paramFacebookException;
      }
      if ((localFacebookException != null) && (LikeView.this.onErrorListener != null)) {
        LikeView.this.onErrorListener.onError(localFacebookException);
      }
      LikeView.access$1202(LikeView.this, null);
      AppMethodBeat.o(8660);
    }
  }
  
  class LikeControllerBroadcastReceiver
    extends BroadcastReceiver
  {
    private LikeControllerBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 1;
      AppMethodBeat.i(8661);
      paramContext = paramIntent.getAction();
      paramIntent = paramIntent.getExtras();
      int i = j;
      if (paramIntent != null)
      {
        String str = paramIntent.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
        i = j;
        if (!Utility.isNullOrEmpty(str)) {
          if (!Utility.areObjectsEqual(LikeView.this.objectId, str)) {
            break label74;
          }
        }
      }
      label74:
      for (i = j; i == 0; i = 0)
      {
        AppMethodBeat.o(8661);
        return;
      }
      if ("com.facebook.sdk.LikeActionController.UPDATED".equals(paramContext))
      {
        LikeView.access$700(LikeView.this);
        AppMethodBeat.o(8661);
        return;
      }
      if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(paramContext))
      {
        if (LikeView.this.onErrorListener != null)
        {
          LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(paramIntent));
          AppMethodBeat.o(8661);
        }
      }
      else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(paramContext))
      {
        LikeView.access$1000(LikeView.this, LikeView.this.objectId, LikeView.this.objectType);
        LikeView.access$700(LikeView.this);
      }
      AppMethodBeat.o(8661);
    }
  }
  
  @Deprecated
  public static enum ObjectType
  {
    public static ObjectType DEFAULT;
    private int intValue;
    private String stringValue;
    
    static
    {
      AppMethodBeat.i(8665);
      UNKNOWN = new ObjectType("UNKNOWN", 0, "unknown", 0);
      OPEN_GRAPH = new ObjectType("OPEN_GRAPH", 1, "open_graph", 1);
      PAGE = new ObjectType("PAGE", 2, "page", 2);
      $VALUES = new ObjectType[] { UNKNOWN, OPEN_GRAPH, PAGE };
      DEFAULT = UNKNOWN;
      AppMethodBeat.o(8665);
    }
    
    private ObjectType(String paramString, int paramInt)
    {
      this.stringValue = paramString;
      this.intValue = paramInt;
    }
    
    public static ObjectType fromInt(int paramInt)
    {
      AppMethodBeat.i(8664);
      ObjectType[] arrayOfObjectType = values();
      int j = arrayOfObjectType.length;
      int i = 0;
      while (i < j)
      {
        ObjectType localObjectType = arrayOfObjectType[i];
        if (localObjectType.getValue() == paramInt)
        {
          AppMethodBeat.o(8664);
          return localObjectType;
        }
        i += 1;
      }
      AppMethodBeat.o(8664);
      return null;
    }
    
    public final int getValue()
    {
      return this.intValue;
    }
    
    public final String toString()
    {
      return this.stringValue;
    }
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
  
  @Deprecated
  public static enum Style
  {
    static Style DEFAULT;
    private int intValue;
    private String stringValue;
    
    static
    {
      AppMethodBeat.i(8670);
      STANDARD = new Style("STANDARD", 0, "standard", 0);
      BUTTON = new Style("BUTTON", 1, "button", 1);
      BOX_COUNT = new Style("BOX_COUNT", 2, "box_count", 2);
      $VALUES = new Style[] { STANDARD, BUTTON, BOX_COUNT };
      DEFAULT = STANDARD;
      AppMethodBeat.o(8670);
    }
    
    private Style(String paramString, int paramInt)
    {
      this.stringValue = paramString;
      this.intValue = paramInt;
    }
    
    static Style fromInt(int paramInt)
    {
      AppMethodBeat.i(8668);
      Style[] arrayOfStyle = values();
      int j = arrayOfStyle.length;
      int i = 0;
      while (i < j)
      {
        Style localStyle = arrayOfStyle[i];
        if (localStyle.getValue() == paramInt)
        {
          AppMethodBeat.o(8668);
          return localStyle;
        }
        i += 1;
      }
      AppMethodBeat.o(8668);
      return null;
    }
    
    private int getValue()
    {
      return this.intValue;
    }
    
    public final String toString()
    {
      return this.stringValue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.widget.LikeView
 * JD-Core Version:    0.7.0.1
 */