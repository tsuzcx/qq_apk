package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private View.OnClickListener pzq;
  private View uAa;
  private GameDropdownView.b uzV;
  private LinkedList<String> uzW;
  private int uzX;
  private int uzY;
  private a uzZ;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.uzX = 0;
    this.uzY = 0;
    this.uzZ = null;
    this.uAa = null;
    this.pzq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42084);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.uzV = new GameDropdownView.b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.uzV.getContentView() == null) || (!(this.uzV.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.uzV.getContentView();
    if ((paramInt > this.uzY) || (this.uzX > this.uzY) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.uzX) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.uzX)).setTextColor(this.mContext.getResources().getColor(2131100490));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131100711));
    setText((CharSequence)this.uzW.get(paramInt));
    if ((this.uzZ != null) && (this.uzX != paramInt)) {
      this.uzZ.Iu(paramInt);
    }
    this.uzX = paramInt;
    AppMethodBeat.o(42091);
  }
  
  public final void h(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42090);
    if (paramLinkedList.size() == 0)
    {
      ae.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(42090);
      return;
    }
    this.uzW = paramLinkedList;
    this.uzY = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.uzY)) {}
    LinearLayout localLinearLayout;
    for (this.uzX = 0;; this.uzX = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2131494331, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131494332, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.pzq);
        if (paramInt == this.uzX)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100711));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.uzV.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.uzV.isShowing()) {
      this.uzV.dismiss();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameDropdownView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42089);
      return;
      if (this.uAa == null) {
        this.uzV.showAsDropDown(this);
      } else {
        this.uzV.showAsDropDown(this.uAa);
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
    this.uAa = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.uzZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Iu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */