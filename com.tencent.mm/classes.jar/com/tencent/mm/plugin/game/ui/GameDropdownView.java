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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private View.OnClickListener qOH;
  private b xRU;
  private LinkedList<String> xRV;
  private int xRW;
  private int xRX;
  private a xRY;
  private View xRZ;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.xRW = 0;
    this.xRX = 0;
    this.xRY = null;
    this.xRZ = null;
    this.qOH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42084);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.xRU = new b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.xRU.getContentView() == null) || (!(this.xRU.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.xRU.getContentView();
    if ((paramInt > this.xRX) || (this.xRW > this.xRX) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.xRW) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.xRW)).setTextColor(this.mContext.getResources().getColor(2131100594));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131100904));
    setText((CharSequence)this.xRV.get(paramInt));
    if ((this.xRY != null) && (this.xRW != paramInt)) {
      this.xRY.Ov(paramInt);
    }
    this.xRW = paramInt;
    AppMethodBeat.o(42091);
  }
  
  public final void g(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42090);
    if (paramLinkedList.size() == 0)
    {
      Log.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(42090);
      return;
    }
    this.xRV = paramLinkedList;
    this.xRX = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.xRX)) {}
    LinearLayout localLinearLayout;
    for (this.xRW = 0;; this.xRW = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2131494895, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131494896, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.qOH);
        if (paramInt == this.xRW)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100904));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.xRU.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xRU.isShowing()) {
      this.xRU.dismiss();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42089);
      return;
      if (this.xRZ == null) {
        this.xRU.showAsDropDown(this);
      } else {
        this.xRU.showAsDropDown(this.xRZ);
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
    this.xRZ = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.xRY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Ov(int paramInt);
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
      setAnimationStyle(2130772073);
      AppMethodBeat.o(42086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */