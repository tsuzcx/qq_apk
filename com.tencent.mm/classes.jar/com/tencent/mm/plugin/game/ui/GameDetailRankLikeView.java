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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.ei;
import com.tencent.mm.plugin.game.protobuf.ej;
import com.tencent.mm.sdk.platformtools.Log;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  private int CKU;
  com.tencent.mm.plugin.game.model.aa CUt;
  com.tencent.mm.plugin.game.model.aa.a CUu;
  private Drawable CUv;
  private Drawable CUw;
  private Animation CUx;
  private ImageView CUy;
  private TextView CUz;
  String mAppId;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.CUz.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.CUz.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.CUz.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  private void st(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.CUy.setImageDrawable(this.CUv);
      AppMethodBeat.o(41989);
      return;
    }
    this.CUy.setImageDrawable(this.CUw);
    AppMethodBeat.o(41989);
  }
  
  final void oA()
  {
    AppMethodBeat.i(41988);
    if (this.CUu != null)
    {
      st(this.CUu.CLg);
      setCount(this.CUu.CLf);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    if (z.bcZ().equals(this.CUu.fPV)) {
      if (this.CUu.CLf > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41991);
      return;
      if (!this.CUu.CLg)
      {
        this.CUu.CLg = true;
        paramView = this.CUu;
        paramView.CLf += 1;
        this.CUt.eyU();
        paramView = this.mAppId;
        localObject1 = this.CUu.fPV;
        Object localObject2 = new d.a();
        ((d.a)localObject2).lBU = new ei();
        ((d.a)localObject2).lBV = new ej();
        ((d.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
        ((d.a)localObject2).funcId = 1330;
        localObject2 = ((d.a)localObject2).bgN();
        ei localei = (ei)d.b.b(((d)localObject2).lBR);
        localei.jUi = paramView;
        localei.CRQ = ((String)localObject1);
        com.tencent.mm.an.aa.a((d)localObject2, new com.tencent.mm.an.aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(41986);
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              AppMethodBeat.o(41986);
              return 0;
            }
            AppMethodBeat.o(41986);
            return 0;
          }
        });
        g.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.CKU, null);
        oA();
        this.CUy.startAnimation(this.CUx);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.CUv = getContext().getResources().getDrawable(g.d.Chj);
    this.CUw = getContext().getResources().getDrawable(g.d.Chi);
    this.CUx = AnimationUtils.loadAnimation(getContext(), g.a.Cgx);
    inflate(getContext(), g.f.CmT, this);
    setOnClickListener(this);
    this.CUy = ((ImageView)findViewById(g.e.CkF));
    this.CUz = ((TextView)findViewById(g.e.CkG));
    AppMethodBeat.o(41987);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.CKU = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */