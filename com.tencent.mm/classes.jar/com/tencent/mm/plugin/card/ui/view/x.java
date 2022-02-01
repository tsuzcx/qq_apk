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
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e.d;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x
  extends i
{
  MMActivity pQZ;
  private TextView qkA;
  private ImageView qkB;
  View qkC;
  private LinearLayout qkD;
  private View.OnClickListener qkE;
  private boolean qkv;
  private View qkw;
  private View qkx;
  private ImageView qky;
  private TextView qkz;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.qkv = false;
    this.qkE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = x.this.qjX.cvq();
        x.this.qjX.cvs();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.pWo == null) || (paramAnonymousView.pWo.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.pWm != null) && (paramAnonymousView.pWm.equals(((com.tencent.mm.plugin.card.base.b)localObject).csW())))
        {
          x.this.qkC.setVisibility(8);
          x.this.qjX.cuE();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.pWm)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).csW())))
        {
          x.this.qkC.setVisibility(8);
          x.this.qjX.cuE();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.ajt(paramAnonymousView.pRX);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.pWm != null) && (localr.pWm.equals(paramAnonymousView.pWm))) || ((TextUtils.isEmpty(localr.pWm)) && (TextUtils.isEmpty(paramAnonymousView.pWm))))
            {
              localr.pWp = true;
              if (!localr.pWq)
              {
                localr.pWq = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.pWp = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.pWo.get(0);
        paramAnonymousView = am.ctY().ajA(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.qjX.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.qjX.cvw() != null)) {
          x.this.qjX.cvw().cvj();
        }
        x.this.qkC.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void cxw()
  {
    AppMethodBeat.i(113715);
    this.qkw.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.qkw = findViewById(2131307835);
    this.qkx = findViewById(2131307837);
    this.qky = ((ImageView)findViewById(2131307829));
    this.qkz = ((TextView)findViewById(2131307830));
    this.qkA = ((TextView)findViewById(2131307832));
    this.qkB = ((ImageView)findViewById(2131307831));
    this.qkw.setVisibility(8);
    this.qkC = findViewById(2131307833);
    this.qkD = ((LinearLayout)findViewById(2131307834));
    this.qkC.setVisibility(8);
    this.pQZ = this.qjX.cvt();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.qjX.cvq();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.ajt(((com.tencent.mm.plugin.card.base.b)localObject4).csV());
    Object localObject1 = this.qjX.cvv();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).cwG())
    {
      this.qkw.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.ajs(((com.tencent.mm.plugin.card.base.b)localObject4).csV()) > 1) {
        this.qkx.setOnClickListener(this.qjX.cvu());
      }
      for (;;)
      {
        localObject4 = this.qjX.cvq();
        if (!this.qjX.cvr()) {
          break;
        }
        this.qky.setVisibility(8);
        this.qkz.setVisibility(8);
        this.qkA.setVisibility(0);
        this.qkB.setImageResource(2131231562);
        this.qkA.setText(this.pQZ.getString(2131757155));
        if (!this.qjX.cvr()) {
          break label881;
        }
        this.qkC.setVisibility(0);
        if ((this.qkD.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.pQZ.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2131496302, this.qkD, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131309633);
          localObject5 = (TextView)((View)localObject4).findViewById(2131309642);
          localObject6 = (TextView)((View)localObject4).findViewById(2131307799);
          if (!TextUtils.isEmpty(((r)localObject3).pWm))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).pWm);
            localObject7 = com.tencent.mm.plugin.card.d.l.akg(((r)localObject3).pWm);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.pQZ, (CharSequence)localObject7, this.pQZ.getResources().getDimensionPixelOffset(2131165594)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).pWn);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.qkE);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131309635);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131309634);
          if (!((r)localObject3).pWp) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.qkD.addView((View)localObject4);
        }
        this.qkB.setVisibility(8);
        this.qkC.setVisibility(8);
        this.qkD.removeAllViews();
        this.qjX.cvs();
      }
      this.qky.setVisibility(0);
      this.qkz.setVisibility(0);
      this.qkA.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.ajs(((com.tencent.mm.plugin.card.base.b)localObject4).csV()) <= 1)
      {
        this.qkB.setVisibility(8);
        label531:
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break label1070;
        }
        i = 0;
        label546:
        if (i >= ((ArrayList)localObject3).size()) {
          break label1070;
        }
        localObject1 = (r)((ArrayList)localObject3).get(i);
        if (!((r)localObject1).pWp) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).pWm;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).csW())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).csW();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.qky, (String)localObject2);
      localObject1 = this.pQZ.getString(2131757160, new Object[] { com.tencent.mm.plugin.card.d.l.akg((String)localObject2) });
      this.qkz.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.pQZ, (CharSequence)localObject1, this.pQZ.getResources().getDimensionPixelOffset(2131165535)));
      break;
      this.qkB.setVisibility(0);
      this.qkB.setImageResource(2131231561);
      break label531;
      label698:
      i += 1;
      break label546;
      ((TextView)localObject5).setText("");
      break label347;
      label716:
      ((ImageView)localObject5).setVisibility(8);
      ((ImageView)localObject6).setVisibility(8);
      break label434;
      label733:
      this.qkD.invalidate();
      this.qkv = true;
      AppMethodBeat.o(113714);
      return;
      label751:
      i = 0;
      if (i < this.qkD.getChildCount())
      {
        localObject2 = this.qkD.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.qkD.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131309635);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131309634);
        if ((localObject1 != null) && (((r)localObject1).pWp))
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
        this.qkD.invalidate();
        break;
        label881:
        this.qkC.setVisibility(8);
        this.qkD.removeAllViews();
        break;
        if (!((g)localObject1).cwG())
        {
          this.qkw.setVisibility(0);
          this.qky.setVisibility(0);
          this.qkz.setVisibility(0);
          this.qkA.setVisibility(8);
          this.qkB.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).csW())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).csW();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.qky, (String)localObject1);
            localObject1 = this.pQZ.getString(2131757160, new Object[] { com.tencent.mm.plugin.card.d.l.akg((String)localObject1) });
            this.qkz.setText(com.tencent.mm.pluginsdk.ui.span.l.i(this.pQZ, (CharSequence)localObject1, this.pQZ.getResources().getDimensionPixelOffset(2131165535)));
          }
          this.qkv = true;
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