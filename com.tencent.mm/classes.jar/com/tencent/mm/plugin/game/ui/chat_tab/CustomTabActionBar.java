package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;

public class CustomTabActionBar
  extends FrameLayout
{
  ImageView CvS;
  private View Dbo;
  private Context mContext;
  private TextView mLH;
  
  public CustomTabActionBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202315);
    initView();
    AppMethodBeat.o(202315);
  }
  
  public CustomTabActionBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202317);
    initView();
    AppMethodBeat.o(202317);
  }
  
  private void initView()
  {
    AppMethodBeat.i(202320);
    this.mContext = getContext();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.Coh, this, false);
    this.Dbo = localView.findViewById(g.e.actionbar_up_indicator);
    this.mLH = ((TextView)localView.findViewById(g.e.title));
    this.CvS = ((ImageView)localView.findViewById(g.e.actionbar_option_btn));
    this.Dbo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192730);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((Activity)CustomTabActionBar.a(CustomTabActionBar.this)).finish();
        a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192730);
      }
    });
    addView(localView, new FrameLayout.LayoutParams(-1, ax.ew(MMApplicationContext.getContext())));
    AppMethodBeat.o(202320);
  }
  
  public void setBackBtn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(202321);
    this.Dbo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(202321);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(202323);
    this.mLH.setText(paramInt);
    AppMethodBeat.o(202323);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(202324);
    this.mLH.setText(paramString);
    AppMethodBeat.o(202324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.CustomTabActionBar
 * JD-Core Version:    0.7.0.1
 */