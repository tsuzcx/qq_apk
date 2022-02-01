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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
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
  private boolean oOZ;
  private View oPa;
  private View oPb;
  private ImageView oPc;
  private TextView oPd;
  private TextView oPe;
  private ImageView oPf;
  View oPg;
  private LinearLayout oPh;
  private View.OnClickListener oPi;
  MMActivity owO;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.oOZ = false;
    this.oPi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = x.this.oOB.bWl();
        x.this.oOB.bWn();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.oBY == null) || (paramAnonymousView.oBY.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.oBW != null) && (paramAnonymousView.oBW.equals(((com.tencent.mm.plugin.card.base.b)localObject).bTT())))
        {
          x.this.oPg.setVisibility(8);
          x.this.oOB.bVy();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.oBW)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bTT())))
        {
          x.this.oPg.setVisibility(8);
          x.this.oOB.bVy();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.Yx(paramAnonymousView.oxM);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.oBW != null) && (localr.oBW.equals(paramAnonymousView.oBW))) || ((TextUtils.isEmpty(localr.oBW)) && (TextUtils.isEmpty(paramAnonymousView.oBW))))
            {
              localr.oBZ = true;
              if (!localr.oCa)
              {
                localr.oCa = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.oBZ = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.oBY.get(0);
        paramAnonymousView = am.bUV().YE(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.oOB.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.oOB.bWr() != null)) {
          x.this.oOB.bWr().bWe();
        }
        x.this.oPg.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void bYr()
  {
    AppMethodBeat.i(113715);
    this.oPa.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.oPa = findViewById(2131304760);
    this.oPb = findViewById(2131304762);
    this.oPc = ((ImageView)findViewById(2131304754));
    this.oPd = ((TextView)findViewById(2131304755));
    this.oPe = ((TextView)findViewById(2131304757));
    this.oPf = ((ImageView)findViewById(2131304756));
    this.oPa.setVisibility(8);
    this.oPg = findViewById(2131304758);
    this.oPh = ((LinearLayout)findViewById(2131304759));
    this.oPg.setVisibility(8);
    this.owO = this.oOB.bWo();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.oOB.bWl();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.Yx(((com.tencent.mm.plugin.card.base.b)localObject4).bTS());
    Object localObject1 = this.oOB.bWq();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).bXB())
    {
      this.oPa.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.Yw(((com.tencent.mm.plugin.card.base.b)localObject4).bTS()) > 1) {
        this.oPb.setOnClickListener(this.oOB.bWp());
      }
      for (;;)
      {
        localObject4 = this.oOB.bWl();
        if (!this.oOB.bWm()) {
          break;
        }
        this.oPc.setVisibility(8);
        this.oPd.setVisibility(8);
        this.oPe.setVisibility(0);
        this.oPf.setImageResource(2131231498);
        this.oPe.setText(this.owO.getString(2131756985));
        if (!this.oOB.bWm()) {
          break label881;
        }
        this.oPg.setVisibility(0);
        if ((this.oPh.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.owO.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2131495431, this.oPh, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131306234);
          localObject5 = (TextView)((View)localObject4).findViewById(2131306243);
          localObject6 = (TextView)((View)localObject4).findViewById(2131304738);
          if (!TextUtils.isEmpty(((r)localObject3).oBW))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).oBW);
            localObject7 = l.Zj(((r)localObject3).oBW);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.owO, (CharSequence)localObject7, this.owO.getResources().getDimensionPixelOffset(2131165576)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).oBX);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.oPi);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131306236);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131306235);
          if (!((r)localObject3).oBZ) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.oPh.addView((View)localObject4);
        }
        this.oPf.setVisibility(8);
        this.oPg.setVisibility(8);
        this.oPh.removeAllViews();
        this.oOB.bWn();
      }
      this.oPc.setVisibility(0);
      this.oPd.setVisibility(0);
      this.oPe.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.Yw(((com.tencent.mm.plugin.card.base.b)localObject4).bTS()) <= 1)
      {
        this.oPf.setVisibility(8);
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
        if (!((r)localObject1).oBZ) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).oBW;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bTT())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).bTT();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.oPc, (String)localObject2);
      localObject1 = this.owO.getString(2131756990, new Object[] { l.Zj((String)localObject2) });
      this.oPd.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.owO, (CharSequence)localObject1, this.owO.getResources().getDimensionPixelOffset(2131165517)));
      break;
      this.oPf.setVisibility(0);
      this.oPf.setImageResource(2131231497);
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
      this.oPh.invalidate();
      this.oOZ = true;
      AppMethodBeat.o(113714);
      return;
      label751:
      i = 0;
      if (i < this.oPh.getChildCount())
      {
        localObject2 = this.oPh.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.oPh.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131306236);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131306235);
        if ((localObject1 != null) && (((r)localObject1).oBZ))
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
        this.oPh.invalidate();
        break;
        label881:
        this.oPg.setVisibility(8);
        this.oPh.removeAllViews();
        break;
        if (!((g)localObject1).bXB())
        {
          this.oPa.setVisibility(0);
          this.oPc.setVisibility(0);
          this.oPd.setVisibility(0);
          this.oPe.setVisibility(8);
          this.oPf.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bTT())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).bTT();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.oPc, (String)localObject1);
            localObject1 = this.owO.getString(2131756990, new Object[] { l.Zj((String)localObject1) });
            this.oPd.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.owO, (CharSequence)localObject1, this.owO.getResources().getDimensionPixelOffset(2131165517)));
          }
          this.oOZ = true;
        }
        AppMethodBeat.o(113714);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */