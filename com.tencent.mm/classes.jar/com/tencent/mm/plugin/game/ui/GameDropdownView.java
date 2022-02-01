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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private View.OnClickListener psK;
  private LinkedList<String> uoA;
  private int uoB;
  private int uoC;
  private a uoD;
  private View uoE;
  private b uoz;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.uoB = 0;
    this.uoC = 0;
    this.uoD = null;
    this.uoE = null;
    this.psK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42084);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.uoz = new b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.uoz.getContentView() == null) || (!(this.uoz.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.uoz.getContentView();
    if ((paramInt > this.uoC) || (this.uoB > this.uoC) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.uoB) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.uoB)).setTextColor(this.mContext.getResources().getColor(2131100490));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131100711));
    setText((CharSequence)this.uoA.get(paramInt));
    if ((this.uoD != null) && (this.uoB != paramInt)) {
      this.uoD.HW(paramInt);
    }
    this.uoB = paramInt;
    AppMethodBeat.o(42091);
  }
  
  public final void g(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42090);
    if (paramLinkedList.size() == 0)
    {
      ad.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(42090);
      return;
    }
    this.uoA = paramLinkedList;
    this.uoC = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.uoC)) {}
    LinearLayout localLinearLayout;
    for (this.uoB = 0;; this.uoB = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2131494331, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131494332, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.psK);
        if (paramInt == this.uoB)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100711));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.uoz.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.uoz.isShowing()) {
      this.uoz.dismiss();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42089);
      return;
      if (this.uoE == null) {
        this.uoz.showAsDropDown(this);
      } else {
        this.uoz.showAsDropDown(this.uoE);
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
    this.uoE = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.uoD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void HW(int paramInt);
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
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (paramAnonymousMotionEvent.getAction() == 4)
          {
            GameDropdownView.b.this.dismiss();
            a.a(true, this, "com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(42085);
            return true;
          }
          a.a(false, this, "com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(42085);
          return false;
        }
      });
      setAnimationStyle(2130772061);
      AppMethodBeat.o(42086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */