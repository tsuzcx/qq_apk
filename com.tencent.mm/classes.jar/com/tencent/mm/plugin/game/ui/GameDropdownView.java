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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private View.OnClickListener oPc;
  private b tqc;
  private LinkedList<String> tqd;
  private int tqe;
  private int tqf;
  private a tqg;
  private View tqh;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.tqe = 0;
    this.tqf = 0;
    this.tqg = null;
    this.tqh = null;
    this.oPc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42084);
        if ((GameDropdownView.a(GameDropdownView.this).getContentView() == null) || (!(GameDropdownView.a(GameDropdownView.this).getContentView() instanceof ViewGroup)))
        {
          GameDropdownView.a(GameDropdownView.this).dismiss();
          AppMethodBeat.o(42084);
          return;
        }
        int i = ((ViewGroup)GameDropdownView.a(GameDropdownView.this).getContentView()).indexOfChild(paramAnonymousView);
        GameDropdownView.a(GameDropdownView.this, i);
        GameDropdownView.a(GameDropdownView.this).dismiss();
        AppMethodBeat.o(42084);
      }
    };
    this.mContext = paramContext;
    this.tqc = new b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.tqc.getContentView() == null) || (!(this.tqc.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.tqc.getContentView();
    if ((paramInt > this.tqf) || (this.tqe > this.tqf) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.tqe) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.tqe)).setTextColor(this.mContext.getResources().getColor(2131100490));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131100711));
    setText((CharSequence)this.tqd.get(paramInt));
    if ((this.tqg != null) && (this.tqe != paramInt)) {
      this.tqg.GD(paramInt);
    }
    this.tqe = paramInt;
    AppMethodBeat.o(42091);
  }
  
  public final void g(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(42090);
    if (paramLinkedList.size() == 0)
    {
      ac.i("MicroMsg.GameDropdownView", "No menu item");
      AppMethodBeat.o(42090);
      return;
    }
    this.tqd = paramLinkedList;
    this.tqf = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.tqf)) {}
    LinearLayout localLinearLayout;
    for (this.tqe = 0;; this.tqe = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2131494331, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131494332, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.oPc);
        if (paramInt == this.tqe)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100711));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.tqc.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    if (this.tqc.isShowing())
    {
      this.tqc.dismiss();
      AppMethodBeat.o(42089);
      return;
    }
    if (this.tqh == null)
    {
      this.tqc.showAsDropDown(this);
      AppMethodBeat.o(42089);
      return;
    }
    this.tqc.showAsDropDown(this.tqh);
    AppMethodBeat.o(42089);
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
    this.tqh = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.tqg = parama;
  }
  
  public static abstract interface a
  {
    public abstract void GD(int paramInt);
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
      setAnimationStyle(2130772061);
      AppMethodBeat.o(42086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */