package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private a IQA;
  private View IQB;
  private b IQw;
  private LinkedList<String> IQx;
  private int IQy;
  private int IQz;
  private Context mContext;
  private View.OnClickListener xxi;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.IQy = 0;
    this.IQz = 0;
    this.IQA = null;
    this.IQB = null;
    this.xxi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42084);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((GameDropdownView.a(GameDropdownView.this).getContentView() == null) || (!(GameDropdownView.a(GameDropdownView.this).getContentView() instanceof ViewGroup)))
        {
          GameDropdownView.a(GameDropdownView.this).dismiss();
          a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42084);
          return;
        }
        int i = ((ViewGroup)GameDropdownView.a(GameDropdownView.this).getContentView()).indexOfChild(paramAnonymousView);
        GameDropdownView.a(GameDropdownView.this, i);
        GameDropdownView.a(GameDropdownView.this).dismiss();
        a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42084);
      }
    };
    this.mContext = paramContext;
    this.IQw = new b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.IQw.getContentView() == null) || (!(this.IQw.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.IQw.getContentView();
    if ((paramInt > this.IQz) || (this.IQy > this.IQz) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.IQy) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.IQy)).setTextColor(this.mContext.getResources().getColor(h.b.hint_text_color));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(h.b.normal_text_color));
    setText((CharSequence)this.IQx.get(paramInt));
    if ((this.IQA != null) && (this.IQy != paramInt)) {
      this.IQA.XJ(paramInt);
    }
    this.IQy = paramInt;
    AppMethodBeat.o(42091);
  }
  
  public final void j(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42090);
    if (paramLinkedList.size() == 0)
    {
      Log.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(42090);
      return;
    }
    this.IQx = paramLinkedList;
    this.IQz = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.IQz)) {}
    LinearLayout localLinearLayout;
    for (this.IQy = 0;; this.IQy = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(h.f.HZK, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(h.f.HZL, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.xxi);
        if (paramInt == this.IQy)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(h.b.normal_text_color));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.IQw.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.IQw.isShowing()) {
      this.IQw.dismiss();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42089);
      return;
      if (this.IQB == null) {
        this.IQw.showAsDropDown(this);
      } else {
        this.IQw.showAsDropDown(this.IQB);
      }
    }
  }
  
  public void onDismiss() {}
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42088);
    super.onFinishInflate();
    setVisibility(8);
    AppMethodBeat.o(42088);
  }
  
  public void setAnchorView(View paramView)
  {
    this.IQB = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.IQA = parama;
  }
  
  public static abstract interface a
  {
    public abstract void XJ(int paramInt);
  }
  
  static final class b
    extends PopupWindow
  {
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(42086);
      setWindowLayoutMode(-1, -2);
      setBackgroundDrawable(new BitmapDrawable());
      setFocusable(true);
      setOutsideTouchable(true);
      setTouchInterceptor(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(42085);
          if (paramAnonymousMotionEvent.getAction() == 4)
          {
            GameDropdownView.b.this.dismiss();
            AppMethodBeat.o(42085);
            return true;
          }
          AppMethodBeat.o(42085);
          return false;
        }
      });
      setAnimationStyle(h.a.HSE);
      AppMethodBeat.o(42086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */