package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.game.report.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.sdk.platformtools.ab;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  String mAppId;
  private int nok;
  aa nwW;
  aa.a nwX;
  private Drawable nwY;
  private Drawable nwZ;
  private Animation nxa;
  private ImageView nxb;
  private TextView nxc;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void im(boolean paramBoolean)
  {
    AppMethodBeat.i(111820);
    if (paramBoolean)
    {
      this.nxb.setImageDrawable(this.nwY);
      AppMethodBeat.o(111820);
      return;
    }
    this.nxb.setImageDrawable(this.nwZ);
    AppMethodBeat.o(111820);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(111821);
    if (paramInt > 99)
    {
      this.nxc.setText("99+");
      AppMethodBeat.o(111821);
      return;
    }
    if (paramInt == 0)
    {
      this.nxc.setText("");
      AppMethodBeat.o(111821);
      return;
    }
    this.nxc.setText(String.valueOf(paramInt));
    AppMethodBeat.o(111821);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111822);
    if (r.Zn().equals(this.nwX.cDt))
    {
      if (this.nwX.noy > 0)
      {
        paramView = new Intent(getContext(), GameDetailRankLikedUI.class);
        paramView.putExtra("extra_appdi", this.mAppId);
        getContext().startActivity(paramView);
        AppMethodBeat.o(111822);
      }
    }
    else if (!this.nwX.noz)
    {
      this.nwX.noz = true;
      paramView = this.nwX;
      paramView.noy += 1;
      this.nwW.bGJ();
      paramView = this.mAppId;
      String str = this.nwX.cDt;
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new dj();
      ((b.a)localObject).fsY = new dk();
      ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/upfriend";
      ((b.a)localObject).funcId = 1330;
      localObject = ((b.a)localObject).ado();
      dj localdj = (dj)((b)localObject).fsV.fta;
      localdj.npZ = paramView;
      localdj.nul = str;
      w.a((b)localObject, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, m paramAnonymousm)
        {
          AppMethodBeat.i(111817);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ab.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(111817);
            return 0;
          }
          AppMethodBeat.o(111817);
          return 0;
        }
      });
      c.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.nok, null);
      resetState();
      this.nxb.startAnimation(this.nxa);
    }
    AppMethodBeat.o(111822);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111818);
    super.onFinishInflate();
    this.nwY = getContext().getResources().getDrawable(2130839028);
    this.nwZ = getContext().getResources().getDrawable(2130839027);
    this.nxa = AnimationUtils.loadAnimation(getContext(), 2131034246);
    inflate(getContext(), 2130969733, this);
    setOnClickListener(this);
    this.nxb = ((ImageView)findViewById(2131824587));
    this.nxc = ((TextView)findViewById(2131824588));
    AppMethodBeat.o(111818);
  }
  
  final void resetState()
  {
    AppMethodBeat.i(111819);
    if (this.nwX != null)
    {
      im(this.nwX.noz);
      setCount(this.nwX.noy);
      AppMethodBeat.o(111819);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(111819);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */