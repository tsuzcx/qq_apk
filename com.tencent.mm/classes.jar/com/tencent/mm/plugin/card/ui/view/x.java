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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e.e;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x
  extends i
{
  private boolean wJQ;
  private View wJR;
  private View wJS;
  private ImageView wJT;
  private TextView wJU;
  private TextView wJV;
  private ImageView wJW;
  View wJX;
  private LinearLayout wJY;
  private View.OnClickListener wJZ;
  MMActivity wry;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.wJQ = false;
    this.wJZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = x.this.wJs.dmk();
        x.this.wJs.dmm();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.wwI == null) || (paramAnonymousView.wwI.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.wwH != null) && (paramAnonymousView.wwH.equals(((com.tencent.mm.plugin.card.base.b)localObject).djQ())))
        {
          x.this.wJX.setVisibility(8);
          x.this.wJs.dlx();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.wwH)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).djQ())))
        {
          x.this.wJX.setVisibility(8);
          x.this.wJs.dlx();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.akL(paramAnonymousView.wsy);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.wwH != null) && (localr.wwH.equals(paramAnonymousView.wwH))) || ((TextUtils.isEmpty(localr.wwH)) && (TextUtils.isEmpty(paramAnonymousView.wwH))))
            {
              localr.wwJ = true;
              if (!localr.wwK)
              {
                localr.wwK = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.wwJ = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.wwI.get(0);
        paramAnonymousView = am.dkR().akS(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.wJs.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.wJs.dmq() != null)) {
          x.this.wJs.dmq().dmc();
        }
        x.this.wJX.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void doE()
  {
    AppMethodBeat.i(113715);
    this.wJR.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.wJR = findViewById(a.d.wll);
    this.wJS = findViewById(a.d.wlm);
    this.wJT = ((ImageView)findViewById(a.d.wlf));
    this.wJU = ((TextView)findViewById(a.d.wlg));
    this.wJV = ((TextView)findViewById(a.d.wli));
    this.wJW = ((ImageView)findViewById(a.d.wlh));
    this.wJR.setVisibility(8);
    this.wJX = findViewById(a.d.wlj);
    this.wJY = ((LinearLayout)findViewById(a.d.wlk));
    this.wJX.setVisibility(8);
    this.wry = this.wJs.dmn();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.wJs.dmk();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.akL(((com.tencent.mm.plugin.card.base.b)localObject4).djP());
    Object localObject1 = this.wJs.dmp();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label354:
    int i;
    if (((g)localObject1).dnz())
    {
      this.wJR.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.akK(((com.tencent.mm.plugin.card.base.b)localObject4).djP()) > 1) {
        this.wJS.setOnClickListener(this.wJs.dmo());
      }
      for (;;)
      {
        localObject4 = this.wJs.dmk();
        if (!this.wJs.dml()) {
          break;
        }
        this.wJT.setVisibility(8);
        this.wJU.setVisibility(8);
        this.wJV.setVisibility(0);
        this.wJW.setImageResource(a.c.weu);
        this.wJV.setText(this.wry.getString(a.g.wqd));
        if (!this.wJs.dml()) {
          break label889;
        }
        this.wJX.setVisibility(0);
        if ((this.wJY.getChildCount() != 0) || (localObject3 == null)) {
          break label759;
        }
        localObject1 = (LayoutInflater)this.wry.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label741;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(a.e.wnQ, this.wJY, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(a.d.wmb);
          localObject5 = (TextView)((View)localObject4).findViewById(a.d.wme);
          localObject6 = (TextView)((View)localObject4).findViewById(a.d.wld);
          if (!TextUtils.isEmpty(((r)localObject3).wwH))
          {
            com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localObject7, ((r)localObject3).wwH);
            localObject7 = l.alx(((r)localObject3).wwH);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(p.h(this.wry, (CharSequence)localObject7, this.wry.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.SmallestTextSize)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).wld);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.wJZ);
          localObject5 = (ImageView)((View)localObject4).findViewById(a.d.wmd);
          localObject6 = (ImageView)((View)localObject4).findViewById(a.d.wmc);
          if (!((r)localObject3).wwJ) {
            break label724;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label442:
          this.wJY.addView((View)localObject4);
        }
        this.wJW.setVisibility(8);
        this.wJX.setVisibility(8);
        this.wJY.removeAllViews();
        this.wJs.dmm();
      }
      this.wJT.setVisibility(0);
      this.wJU.setVisibility(0);
      this.wJV.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.akK(((com.tencent.mm.plugin.card.base.b)localObject4).djP()) <= 1)
      {
        this.wJW.setVisibility(8);
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
        if (!((r)localObject1).wwJ) {
          break label706;
        }
      }
    }
    label1073:
    label1078:
    for (localObject1 = ((r)localObject1).wwH;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).djQ())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).djQ();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      com.tencent.mm.pluginsdk.ui.a.b.g(this.wJT, (String)localObject2);
      localObject1 = this.wry.getString(a.g.wqh, new Object[] { l.alx((String)localObject2) });
      this.wJU.setText(p.h(this.wry, (CharSequence)localObject1, this.wry.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
      break;
      this.wJW.setVisibility(0);
      this.wJW.setImageResource(a.c.wet);
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
      this.wJY.invalidate();
      this.wJQ = true;
      AppMethodBeat.o(113714);
      return;
      label759:
      i = 0;
      if (i < this.wJY.getChildCount())
      {
        localObject2 = this.wJY.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.wJY.getChildCount())) {
          break label1073;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(a.d.wmd);
        localObject2 = (ImageView)((View)localObject2).findViewById(a.d.wmc);
        if ((localObject1 != null) && (((r)localObject1).wwJ))
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
        this.wJY.invalidate();
        break;
        label889:
        this.wJX.setVisibility(8);
        this.wJY.removeAllViews();
        break;
        if (!((g)localObject1).dnz())
        {
          this.wJR.setVisibility(0);
          this.wJT.setVisibility(0);
          this.wJU.setVisibility(0);
          this.wJV.setVisibility(8);
          this.wJW.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).djQ())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).djQ();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            com.tencent.mm.pluginsdk.ui.a.b.g(this.wJT, (String)localObject1);
            localObject1 = this.wry.getString(a.g.wqh, new Object[] { l.alx((String)localObject1) });
            this.wJU.setText(p.h(this.wry, (CharSequence)localObject1, this.wry.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
          }
          this.wJQ = true;
        }
        AppMethodBeat.o(113714);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */