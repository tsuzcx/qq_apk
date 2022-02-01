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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;

public class CustomTabActionBar
  extends FrameLayout
{
  private View IVC;
  ImageView ImI;
  private Context mContext;
  private TextView pIp;
  
  public CustomTabActionBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276687);
    initView();
    AppMethodBeat.o(276687);
  }
  
  public CustomTabActionBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276691);
    initView();
    AppMethodBeat.o(276691);
  }
  
  private void initView()
  {
    AppMethodBeat.i(276696);
    this.mContext = getContext();
    View localView = LayoutInflater.from(getContext()).inflate(h.f.Iap, this, false);
    this.IVC = localView.findViewById(h.e.actionbar_up_indicator);
    this.pIp = ((TextView)localView.findViewById(h.e.title));
    com.tencent.mm.ui.a.v(this.pIp, h.c.BodyTextSize);
    this.ImI = ((ImageView)localView.findViewById(h.e.actionbar_option_btn));
    this.IVC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276711);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ((Activity)CustomTabActionBar.a(CustomTabActionBar.this)).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276711);
      }
    });
    addView(localView, new FrameLayout.LayoutParams(-1, bf.fs(MMApplicationContext.getContext())));
    AppMethodBeat.o(276696);
  }
  
  public void setBackBtn(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(276707);
    this.IVC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(276707);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(276716);
    this.pIp.setText(paramInt);
    AppMethodBeat.o(276716);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(276722);
    this.pIp.setText(paramString);
    AppMethodBeat.o(276722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.CustomTabActionBar
 * JD-Core Version:    0.7.0.1
 */