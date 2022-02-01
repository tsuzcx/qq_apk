package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.login.R.drawable;
import com.facebook.login.R.id;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class ToolTipPopup
{
  public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000L;
  private final WeakReference<View> mAnchorViewRef;
  private final Context mContext;
  private long mNuxDisplayTime;
  private ToolTipPopup.PopupContentView mPopupContent;
  private PopupWindow mPopupWindow;
  private final ViewTreeObserver.OnScrollChangedListener mScrollListener;
  private ToolTipPopup.Style mStyle;
  private final String mText;
  
  public ToolTipPopup(String paramString, View paramView)
  {
    AppMethodBeat.i(40488);
    this.mStyle = ToolTipPopup.Style.BLUE;
    this.mNuxDisplayTime = 6000L;
    this.mScrollListener = new ViewTreeObserver.OnScrollChangedListener()
    {
      public void onScrollChanged()
      {
        AppMethodBeat.i(40478);
        if ((ToolTipPopup.this.mAnchorViewRef.get() != null) && (ToolTipPopup.this.mPopupWindow != null) && (ToolTipPopup.this.mPopupWindow.isShowing()))
        {
          if (ToolTipPopup.this.mPopupWindow.isAboveAnchor())
          {
            ToolTipPopup.this.mPopupContent.showBottomArrow();
            AppMethodBeat.o(40478);
            return;
          }
          ToolTipPopup.this.mPopupContent.showTopArrow();
        }
        AppMethodBeat.o(40478);
      }
    };
    this.mText = paramString;
    this.mAnchorViewRef = new WeakReference(paramView);
    this.mContext = paramView.getContext();
    AppMethodBeat.o(40488);
  }
  
  private void registerObserver()
  {
    AppMethodBeat.i(40492);
    unregisterObserver();
    if (this.mAnchorViewRef.get() != null) {
      ((View)this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
    }
    AppMethodBeat.o(40492);
  }
  
  private void unregisterObserver()
  {
    AppMethodBeat.i(40493);
    if (this.mAnchorViewRef.get() != null) {
      ((View)this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
    }
    AppMethodBeat.o(40493);
  }
  
  private void updateArrows()
  {
    AppMethodBeat.i(40490);
    if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing()))
    {
      if (this.mPopupWindow.isAboveAnchor())
      {
        this.mPopupContent.showBottomArrow();
        AppMethodBeat.o(40490);
        return;
      }
      this.mPopupContent.showTopArrow();
    }
    AppMethodBeat.o(40490);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(40491);
    unregisterObserver();
    if (this.mPopupWindow != null) {
      this.mPopupWindow.dismiss();
    }
    AppMethodBeat.o(40491);
  }
  
  public void setNuxDisplayTime(long paramLong)
  {
    this.mNuxDisplayTime = paramLong;
  }
  
  public void setStyle(ToolTipPopup.Style paramStyle)
  {
    this.mStyle = paramStyle;
  }
  
  public void show()
  {
    AppMethodBeat.i(40489);
    if (this.mAnchorViewRef.get() != null)
    {
      this.mPopupContent = new ToolTipPopup.PopupContentView(this, this.mContext);
      ((TextView)this.mPopupContent.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
      if (this.mStyle != ToolTipPopup.Style.BLUE) {
        break label268;
      }
      ToolTipPopup.PopupContentView.access$300(this.mPopupContent).setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
      ToolTipPopup.PopupContentView.access$400(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
      ToolTipPopup.PopupContentView.access$500(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
      ToolTipPopup.PopupContentView.access$600(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
    }
    for (;;)
    {
      View localView = ((Activity)this.mContext).getWindow().getDecorView();
      int i = localView.getWidth();
      int j = localView.getHeight();
      registerObserver();
      this.mPopupContent.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
      this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
      this.mPopupWindow.showAsDropDown((View)this.mAnchorViewRef.get());
      updateArrows();
      if (this.mNuxDisplayTime > 0L) {
        this.mPopupContent.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(40479);
            ToolTipPopup.this.dismiss();
            AppMethodBeat.o(40479);
          }
        }, this.mNuxDisplayTime);
      }
      this.mPopupWindow.setTouchable(true);
      this.mPopupContent.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(40480);
          ToolTipPopup.this.dismiss();
          AppMethodBeat.o(40480);
        }
      });
      AppMethodBeat.o(40489);
      return;
      label268:
      ToolTipPopup.PopupContentView.access$300(this.mPopupContent).setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
      ToolTipPopup.PopupContentView.access$400(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
      ToolTipPopup.PopupContentView.access$500(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
      ToolTipPopup.PopupContentView.access$600(this.mPopupContent).setImageResource(R.drawable.com_facebook_tooltip_black_xout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.widget.ToolTipPopup
 * JD-Core Version:    0.7.0.1
 */