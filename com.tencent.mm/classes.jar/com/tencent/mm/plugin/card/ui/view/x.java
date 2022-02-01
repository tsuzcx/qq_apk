package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e.d;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x
  extends i
{
  private View.OnClickListener tGA;
  private boolean tGr;
  private View tGs;
  private View tGt;
  private ImageView tGu;
  private TextView tGv;
  private TextView tGw;
  private ImageView tGx;
  View tGy;
  private LinearLayout tGz;
  MMActivity tmY;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.tGr = false;
    this.tGA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = x.this.tFT.cIS();
        x.this.tFT.cIU();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.tsl == null) || (paramAnonymousView.tsl.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.tsk != null) && (paramAnonymousView.tsk.equals(((com.tencent.mm.plugin.card.base.b)localObject).cGy())))
        {
          x.this.tGy.setVisibility(8);
          x.this.tFT.cIg();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.tsk)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).cGy())))
        {
          x.this.tGy.setVisibility(8);
          x.this.tFT.cIg();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.arg(paramAnonymousView.tnX);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.tsk != null) && (localr.tsk.equals(paramAnonymousView.tsk))) || ((TextUtils.isEmpty(localr.tsk)) && (TextUtils.isEmpty(paramAnonymousView.tsk))))
            {
              localr.tsm = true;
              if (!localr.tsn)
              {
                localr.tsn = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.tsm = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.tsl.get(0);
        paramAnonymousView = am.cHA().arn(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.tFT.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.tFT.cIY() != null)) {
          x.this.tFT.cIY().cIL();
        }
        x.this.tGy.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void cKY()
  {
    AppMethodBeat.i(113715);
    this.tGs.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.tGs = findViewById(a.d.tgM);
    this.tGt = findViewById(a.d.tgN);
    this.tGu = ((ImageView)findViewById(a.d.tgG));
    this.tGv = ((TextView)findViewById(a.d.tgH));
    this.tGw = ((TextView)findViewById(a.d.tgJ));
    this.tGx = ((ImageView)findViewById(a.d.tgI));
    this.tGs.setVisibility(8);
    this.tGy = findViewById(a.d.tgK);
    this.tGz = ((LinearLayout)findViewById(a.d.tgL));
    this.tGy.setVisibility(8);
    this.tmY = this.tFT.cIV();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.tFT.cIS();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.arg(((com.tencent.mm.plugin.card.base.b)localObject4).cGx());
    Object localObject1 = this.tFT.cIX();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label354:
    int i;
    if (((g)localObject1).cKj())
    {
      this.tGs.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.arf(((com.tencent.mm.plugin.card.base.b)localObject4).cGx()) > 1) {
        this.tGt.setOnClickListener(this.tFT.cIW());
      }
      for (;;)
      {
        localObject4 = this.tFT.cIS();
        if (!this.tFT.cIT()) {
          break;
        }
        this.tGu.setVisibility(8);
        this.tGv.setVisibility(8);
        this.tGw.setVisibility(0);
        this.tGx.setImageResource(a.c.tam);
        this.tGw.setText(this.tmY.getString(a.g.tlE));
        if (!this.tFT.cIT()) {
          break label889;
        }
        this.tGy.setVisibility(0);
        if ((this.tGz.getChildCount() != 0) || (localObject3 == null)) {
          break label759;
        }
        localObject1 = (LayoutInflater)this.tmY.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label741;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(a.e.tjt, this.tGz, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(a.d.thB);
          localObject5 = (TextView)((View)localObject4).findViewById(a.d.thE);
          localObject6 = (TextView)((View)localObject4).findViewById(a.d.tgE);
          if (!TextUtils.isEmpty(((r)localObject3).tsk))
          {
            com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)localObject7, ((r)localObject3).tsk);
            localObject7 = com.tencent.mm.plugin.card.d.l.arT(((r)localObject3).tsk);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.tmY, (CharSequence)localObject7, this.tmY.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.SmallestTextSize)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).tgE);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.tGA);
          localObject5 = (ImageView)((View)localObject4).findViewById(a.d.thD);
          localObject6 = (ImageView)((View)localObject4).findViewById(a.d.thC);
          if (!((r)localObject3).tsm) {
            break label724;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label442:
          this.tGz.addView((View)localObject4);
        }
        this.tGx.setVisibility(8);
        this.tGy.setVisibility(8);
        this.tGz.removeAllViews();
        this.tFT.cIU();
      }
      this.tGu.setVisibility(0);
      this.tGv.setVisibility(0);
      this.tGw.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.arf(((com.tencent.mm.plugin.card.base.b)localObject4).cGx()) <= 1)
      {
        this.tGx.setVisibility(8);
        label539:
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break label1078;
        }
        i = 0;
        label554:
        if (i >= ((ArrayList)localObject3).size()) {
          break label1078;
        }
        localObject1 = (r)((ArrayList)localObject3).get(i);
        if (!((r)localObject1).tsm) {
          break label706;
        }
      }
    }
    label1073:
    label1078:
    for (localObject1 = ((r)localObject1).tsk;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).cGy())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).cGy();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      com.tencent.mm.pluginsdk.ui.a.b.c(this.tGu, (String)localObject2);
      localObject1 = this.tmY.getString(a.g.tlI, new Object[] { com.tencent.mm.plugin.card.d.l.arT((String)localObject2) });
      this.tGv.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.tmY, (CharSequence)localObject1, this.tmY.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
      break;
      this.tGx.setVisibility(0);
      this.tGx.setImageResource(a.c.tal);
      break label539;
      label706:
      i += 1;
      break label554;
      ((TextView)localObject5).setText("");
      break label354;
      label724:
      ((ImageView)localObject5).setVisibility(8);
      ((ImageView)localObject6).setVisibility(8);
      break label442;
      label741:
      this.tGz.invalidate();
      this.tGr = true;
      AppMethodBeat.o(113714);
      return;
      label759:
      i = 0;
      if (i < this.tGz.getChildCount())
      {
        localObject2 = this.tGz.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.tGz.getChildCount())) {
          break label1073;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(a.d.thD);
        localObject2 = (ImageView)((View)localObject2).findViewById(a.d.thC);
        if ((localObject1 != null) && (((r)localObject1).tsm))
        {
          ((ImageView)localObject4).setVisibility(0);
          ((ImageView)localObject2).setVisibility(0);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ImageView)localObject4).setVisibility(8);
          ((ImageView)localObject2).setVisibility(8);
        }
        this.tGz.invalidate();
        break;
        label889:
        this.tGy.setVisibility(8);
        this.tGz.removeAllViews();
        break;
        if (!((g)localObject1).cKj())
        {
          this.tGs.setVisibility(0);
          this.tGu.setVisibility(0);
          this.tGv.setVisibility(0);
          this.tGw.setVisibility(8);
          this.tGx.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).cGy())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).cGy();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            com.tencent.mm.pluginsdk.ui.a.b.c(this.tGu, (String)localObject1);
            localObject1 = this.tmY.getString(a.g.tlI, new Object[] { com.tencent.mm.plugin.card.d.l.arT((String)localObject1) });
            this.tGv.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.tmY, (CharSequence)localObject1, this.tmY.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
          }
          this.tGr = true;
        }
        AppMethodBeat.o(113714);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */