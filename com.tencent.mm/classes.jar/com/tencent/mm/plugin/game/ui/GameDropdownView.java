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
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class GameDropdownView
  extends TextView
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private b laM;
  private LinkedList<String> laN;
  private int laO = 0;
  private int laP = 0;
  private GameDropdownView.a laQ = null;
  private View laR = null;
  private View.OnClickListener laS = new GameDropdownView.1(this);
  private Context mContext;
  
  public GameDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.laM = new b(paramContext);
    setOnClickListener(this);
  }
  
  private void setCurrentSelection(int paramInt)
  {
    if ((this.laM.getContentView() == null) || (!(this.laM.getContentView() instanceof ViewGroup))) {}
    ViewGroup localViewGroup;
    do
    {
      return;
      localViewGroup = (ViewGroup)this.laM.getContentView();
    } while ((paramInt > this.laP) || (this.laO > this.laP) || (!(localViewGroup.getChildAt(paramInt) instanceof TextView)) || (!(localViewGroup.getChildAt(this.laO) instanceof TextView)));
    ((TextView)localViewGroup.getChildAt(this.laO)).setTextColor(this.mContext.getResources().getColor(g.b.hint_text_color));
    ((TextView)localViewGroup.getChildAt(paramInt)).setTextColor(this.mContext.getResources().getColor(g.b.normal_text_color));
    setText((CharSequence)this.laN.get(paramInt));
    if ((this.laQ != null) && (this.laO != paramInt)) {
      this.laQ.si(paramInt);
    }
    this.laO = paramInt;
  }
  
  public final void e(LinkedList<String> paramLinkedList, int paramInt)
  {
    if (paramLinkedList.size() == 0)
    {
      y.i("MicroMsg.GameDropdownView", "No menu item");
      return;
    }
    this.laN = paramLinkedList;
    this.laP = (paramLinkedList.size() - 1);
    if ((paramInt < 0) || (paramInt > this.laP)) {}
    LinearLayout localLinearLayout;
    for (this.laO = 0;; this.laO = paramInt)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      localLinearLayout = (LinearLayout)localLayoutInflater.inflate(g.f.game_library_dropdown_container, null);
      paramInt = 0;
      while (paramInt < paramLinkedList.size())
      {
        String str = (String)paramLinkedList.get(paramInt);
        TextView localTextView = (TextView)localLayoutInflater.inflate(g.f.game_library_dropdown_item, localLinearLayout, false);
        localTextView.setText(str);
        localTextView.setOnClickListener(this.laS);
        if (paramInt == this.laO)
        {
          localTextView.setTextColor(this.mContext.getResources().getColor(g.b.normal_text_color));
          setText(str);
        }
        localLinearLayout.addView(localTextView);
        paramInt += 1;
      }
    }
    this.laM.setContentView(localLinearLayout);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    if (this.laM.isShowing())
    {
      this.laM.dismiss();
      return;
    }
    if (this.laR == null)
    {
      this.laM.showAsDropDown(this);
      return;
    }
    this.laM.showAsDropDown(this.laR);
  }
  
  public void onDismiss() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setVisibility(8);
  }
  
  public void setAnchorView(View paramView)
  {
    this.laR = paramView;
  }
  
  public void setOnSelectionChangedListener(GameDropdownView.a parama)
  {
    this.laQ = parama;
  }
  
  private static final class b
    extends PopupWindow
  {
    public b(Context paramContext)
    {
      super();
      setWindowLayoutMode(-1, -2);
      setBackgroundDrawable(new BitmapDrawable());
      setFocusable(true);
      setOutsideTouchable(true);
      setTouchInterceptor(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 4)
          {
            GameDropdownView.b.this.dismiss();
            return true;
          }
          return false;
        }
      });
      setAnimationStyle(g.a.game_dropdown);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView
 * JD-Core Version:    0.7.0.1
 */