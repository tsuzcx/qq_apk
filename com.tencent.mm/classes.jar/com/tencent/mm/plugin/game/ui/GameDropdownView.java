package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private GameDropdownView.b nyI;
  private LinkedList<String> nyJ;
  private int nyK;
  private int nyL;
  private GameDropdownView.a nyM;
  private View nyN;
  private View.OnClickListener nyO;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111916);
    this.nyK = 0;
    this.nyL = 0;
    this.nyM = null;
    this.nyN = null;
    this.nyO = new GameDropdownView.1(this);
    this.mContext = paramContext;
    this.nyI = new GameDropdownView.b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(111916);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(111920);
    if ((this.nyI.getContentView() == null) || (!(this.nyI.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(111920);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.nyI.getContentView();
    if ((paramInt > this.nyL) || (this.nyK > this.nyL) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.nyK) instanceof TextView)))
    {
      AppMethodBeat.o(111920);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.nyK)).setTextColor(this.mContext.getResources().getColor(2131690168));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131690322));
    setText((CharSequence)this.nyJ.get(paramInt));
    if ((this.nyM != null) && (this.nyK != paramInt)) {
      this.nyM.xh(paramInt);
    }
    this.nyK = paramInt;
    AppMethodBeat.o(111920);
  }
  
  public final void e(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(111919);
    if (paramLinkedList.size() == 0)
    {
      ab.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(111919);
      return;
    }
    this.nyJ = paramLinkedList;
    this.nyL = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.nyL)) {}
    LinearLayout localLinearLayout;
    for (this.nyK = 0;; this.nyK = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2130969773, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2130969774, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.nyO);
        if (paramInt == this.nyK)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131690322));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.nyI.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(111919);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111918);
    if (this.nyI.isShowing())
    {
      this.nyI.dismiss();
      AppMethodBeat.o(111918);
      return;
    }
    if (this.nyN == null)
    {
      this.nyI.showAsDropDown(this);
      AppMethodBeat.o(111918);
      return;
    }
    this.nyI.showAsDropDown(this.nyN);
    AppMethodBeat.o(111918);
  }
  
  public void onDismiss() {}
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111917);
    super.onFinishInflate();
    setVisibility(8);
    AppMethodBeat.o(111917);
  }
  
  public void setAnchorView(View paramView)
  {
    this.nyN = paramView;
  }
  
  public void setOnSelectionChangedListener(GameDropdownView.a parama)
  {
    this.nyM = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */