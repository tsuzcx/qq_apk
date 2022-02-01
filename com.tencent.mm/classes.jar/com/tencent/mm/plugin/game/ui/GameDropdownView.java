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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private Context mContext;
  private View.OnClickListener olC;
  private b sii;
  private LinkedList<String> sij;
  private int sik;
  private int sil;
  private a sin;
  private View sio;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42087);
    this.sik = 0;
    this.sil = 0;
    this.sin = null;
    this.sio = null;
    this.olC = new View.OnClickListener()
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
    this.sii = new b(paramContext);
    setOnClickListener(this);
    AppMethodBeat.o(42087);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    AppMethodBeat.i(42091);
    if ((this.sii.getContentView() == null) || (!(this.sii.getContentView() instanceof ViewGroup)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.sii.getContentView();
    if ((paramInt > this.sil) || (this.sik > this.sil) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.sik) instanceof TextView)))
    {
      AppMethodBeat.o(42091);
      return;
    }
    ((TextView)localViewGroup.getChildAt(this.sik)).setTextColor(this.mContext.getResources().getColor(2131100490));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(2131100711));
    setText((CharSequence)this.sij.get(paramInt));
    if ((this.sin != null) && (this.sik != paramInt)) {
      this.sin.EH(paramInt);
    }
    this.sik = paramInt;
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
    this.sij = paramLinkedList;
    this.sil = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.sil)) {}
    LinearLayout localLinearLayout;
    for (this.sik = 0;; this.sik = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(2131494331, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131494332, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.olC);
        if (paramInt == this.sik)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(2131100711));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.sii.setContentView(localLinearLayout);
    setVisibility(0);
    AppMethodBeat.o(42090);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42089);
    if (this.sii.isShowing())
    {
      this.sii.dismiss();
      AppMethodBeat.o(42089);
      return;
    }
    if (this.sio == null)
    {
      this.sii.showAsDropDown(this);
      AppMethodBeat.o(42089);
      return;
    }
    this.sii.showAsDropDown(this.sio);
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
    this.sio = paramView;
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.sin = parama;
  }
  
  public static abstract interface a
  {
    public abstract void EH(int paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */