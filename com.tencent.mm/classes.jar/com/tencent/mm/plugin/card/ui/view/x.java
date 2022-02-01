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
  MMActivity oDq;
  private boolean oVB;
  private View oVC;
  private View oVD;
  private ImageView oVE;
  private TextView oVF;
  private TextView oVG;
  private ImageView oVH;
  View oVI;
  private LinearLayout oVJ;
  private View.OnClickListener oVK;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.oVB = false;
    this.oVK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = x.this.oVd.bXA();
        x.this.oVd.bXC();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.oIA == null) || (paramAnonymousView.oIA.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.oIy != null) && (paramAnonymousView.oIy.equals(((com.tencent.mm.plugin.card.base.b)localObject).bVi())))
        {
          x.this.oVI.setVisibility(8);
          x.this.oVd.bWN();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.oIy)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bVi())))
        {
          x.this.oVI.setVisibility(8);
          x.this.oVd.bWN();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.Zo(paramAnonymousView.oEo);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.oIy != null) && (localr.oIy.equals(paramAnonymousView.oIy))) || ((TextUtils.isEmpty(localr.oIy)) && (TextUtils.isEmpty(paramAnonymousView.oIy))))
            {
              localr.oIB = true;
              if (!localr.oIC)
              {
                localr.oIC = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.oIB = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.oIA.get(0);
        paramAnonymousView = am.bWk().Zv(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.oVd.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.oVd.bXG() != null)) {
          x.this.oVd.bXG().bXt();
        }
        x.this.oVI.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardShareUsersInfoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void bZG()
  {
    AppMethodBeat.i(113715);
    this.oVC.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.oVC = findViewById(2131304760);
    this.oVD = findViewById(2131304762);
    this.oVE = ((ImageView)findViewById(2131304754));
    this.oVF = ((TextView)findViewById(2131304755));
    this.oVG = ((TextView)findViewById(2131304757));
    this.oVH = ((ImageView)findViewById(2131304756));
    this.oVC.setVisibility(8);
    this.oVI = findViewById(2131304758);
    this.oVJ = ((LinearLayout)findViewById(2131304759));
    this.oVI.setVisibility(8);
    this.oDq = this.oVd.bXD();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.oVd.bXA();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.Zo(((com.tencent.mm.plugin.card.base.b)localObject4).bVh());
    Object localObject1 = this.oVd.bXF();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).bYQ())
    {
      this.oVC.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.Zn(((com.tencent.mm.plugin.card.base.b)localObject4).bVh()) > 1) {
        this.oVD.setOnClickListener(this.oVd.bXE());
      }
      for (;;)
      {
        localObject4 = this.oVd.bXA();
        if (!this.oVd.bXB()) {
          break;
        }
        this.oVE.setVisibility(8);
        this.oVF.setVisibility(8);
        this.oVG.setVisibility(0);
        this.oVH.setImageResource(2131231498);
        this.oVG.setText(this.oDq.getString(2131756985));
        if (!this.oVd.bXB()) {
          break label881;
        }
        this.oVI.setVisibility(0);
        if ((this.oVJ.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.oDq.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2131495431, this.oVJ, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131306234);
          localObject5 = (TextView)((View)localObject4).findViewById(2131306243);
          localObject6 = (TextView)((View)localObject4).findViewById(2131304738);
          if (!TextUtils.isEmpty(((r)localObject3).oIy))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).oIy);
            localObject7 = l.aaa(((r)localObject3).oIy);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.oDq, (CharSequence)localObject7, this.oDq.getResources().getDimensionPixelOffset(2131165576)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).oIz);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.oVK);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131306236);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131306235);
          if (!((r)localObject3).oIB) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.oVJ.addView((View)localObject4);
        }
        this.oVH.setVisibility(8);
        this.oVI.setVisibility(8);
        this.oVJ.removeAllViews();
        this.oVd.bXC();
      }
      this.oVE.setVisibility(0);
      this.oVF.setVisibility(0);
      this.oVG.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.Zn(((com.tencent.mm.plugin.card.base.b)localObject4).bVh()) <= 1)
      {
        this.oVH.setVisibility(8);
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
        if (!((r)localObject1).oIB) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).oIy;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bVi())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).bVi();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.oVE, (String)localObject2);
      localObject1 = this.oDq.getString(2131756990, new Object[] { l.aaa((String)localObject2) });
      this.oVF.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.oDq, (CharSequence)localObject1, this.oDq.getResources().getDimensionPixelOffset(2131165517)));
      break;
      this.oVH.setVisibility(0);
      this.oVH.setImageResource(2131231497);
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
      this.oVJ.invalidate();
      this.oVB = true;
      AppMethodBeat.o(113714);
      return;
      label751:
      i = 0;
      if (i < this.oVJ.getChildCount())
      {
        localObject2 = this.oVJ.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.oVJ.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131306236);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131306235);
        if ((localObject1 != null) && (((r)localObject1).oIB))
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
        this.oVJ.invalidate();
        break;
        label881:
        this.oVI.setVisibility(8);
        this.oVJ.removeAllViews();
        break;
        if (!((g)localObject1).bYQ())
        {
          this.oVC.setVisibility(0);
          this.oVE.setVisibility(0);
          this.oVF.setVisibility(0);
          this.oVG.setVisibility(8);
          this.oVH.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bVi())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).bVi();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.oVE, (String)localObject1);
            localObject1 = this.oDq.getString(2131756990, new Object[] { l.aaa((String)localObject1) });
            this.oVF.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.oDq, (CharSequence)localObject1, this.oDq.getResources().getDimensionPixelOffset(2131165517)));
          }
          this.oVB = true;
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