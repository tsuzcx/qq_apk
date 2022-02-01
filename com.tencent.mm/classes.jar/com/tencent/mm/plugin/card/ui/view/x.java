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
  private boolean nIE;
  private View nIF;
  private View nIG;
  private ImageView nIH;
  private TextView nII;
  private TextView nIJ;
  private ImageView nIK;
  View nIL;
  private LinearLayout nIM;
  private View.OnClickListener nIN;
  MMActivity nqt;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.nIE = false;
    this.nIN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          AppMethodBeat.o(113711);
          return;
        }
        Object localObject = x.this.nIg.bKt();
        x.this.nIg.bKv();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.nvE == null) || (paramAnonymousView.nvE.isEmpty()))
        {
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.nvC != null) && (paramAnonymousView.nvC.equals(((com.tencent.mm.plugin.card.base.b)localObject).bIb())))
        {
          x.this.nIL.setVisibility(8);
          x.this.nIg.bJG();
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.nvC)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bIb())))
        {
          x.this.nIL.setVisibility(8);
          x.this.nIg.bJG();
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.QC(paramAnonymousView.nrr);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.nvC != null) && (localr.nvC.equals(paramAnonymousView.nvC))) || ((TextUtils.isEmpty(localr.nvC)) && (TextUtils.isEmpty(paramAnonymousView.nvC))))
            {
              localr.nvF = true;
              if (!localr.nvG)
              {
                localr.nvG = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.nvF = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.nvE.get(0);
        paramAnonymousView = am.bJd().QJ(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.nIg.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.nIg.bKz() != null)) {
          x.this.nIg.bKz().bKm();
        }
        x.this.nIL.setVisibility(8);
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void bMB()
  {
    AppMethodBeat.i(113715);
    this.nIF.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.nIF = findViewById(2131304760);
    this.nIG = findViewById(2131304762);
    this.nIH = ((ImageView)findViewById(2131304754));
    this.nII = ((TextView)findViewById(2131304755));
    this.nIJ = ((TextView)findViewById(2131304757));
    this.nIK = ((ImageView)findViewById(2131304756));
    this.nIF.setVisibility(8);
    this.nIL = findViewById(2131304758);
    this.nIM = ((LinearLayout)findViewById(2131304759));
    this.nIL.setVisibility(8);
    this.nqt = this.nIg.bKw();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.nIg.bKt();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.QC(((com.tencent.mm.plugin.card.base.b)localObject4).bIa());
    Object localObject1 = this.nIg.bKy();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).bLJ())
    {
      this.nIF.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.QB(((com.tencent.mm.plugin.card.base.b)localObject4).bIa()) > 1) {
        this.nIG.setOnClickListener(this.nIg.bKx());
      }
      for (;;)
      {
        localObject4 = this.nIg.bKt();
        if (!this.nIg.bKu()) {
          break;
        }
        this.nIH.setVisibility(8);
        this.nII.setVisibility(8);
        this.nIJ.setVisibility(0);
        this.nIK.setImageResource(2131231498);
        this.nIJ.setText(this.nqt.getString(2131756985));
        if (!this.nIg.bKu()) {
          break label881;
        }
        this.nIL.setVisibility(0);
        if ((this.nIM.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.nqt.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2131495431, this.nIM, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131306234);
          localObject5 = (TextView)((View)localObject4).findViewById(2131306243);
          localObject6 = (TextView)((View)localObject4).findViewById(2131304738);
          if (!TextUtils.isEmpty(((r)localObject3).nvC))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).nvC);
            localObject7 = l.Ro(((r)localObject3).nvC);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.k.e(this.nqt, (CharSequence)localObject7, this.nqt.getResources().getDimensionPixelOffset(2131165576)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).nvD);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.nIN);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131306236);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131306235);
          if (!((r)localObject3).nvF) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.nIM.addView((View)localObject4);
        }
        this.nIK.setVisibility(8);
        this.nIL.setVisibility(8);
        this.nIM.removeAllViews();
        this.nIg.bKv();
      }
      this.nIH.setVisibility(0);
      this.nII.setVisibility(0);
      this.nIJ.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.QB(((com.tencent.mm.plugin.card.base.b)localObject4).bIa()) <= 1)
      {
        this.nIK.setVisibility(8);
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
        if (!((r)localObject1).nvF) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).nvC;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bIb())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).bIb();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.nIH, (String)localObject2);
      localObject1 = this.nqt.getString(2131756990, new Object[] { l.Ro((String)localObject2) });
      this.nII.setText(com.tencent.mm.pluginsdk.ui.span.k.e(this.nqt, (CharSequence)localObject1, this.nqt.getResources().getDimensionPixelOffset(2131165517)));
      break;
      this.nIK.setVisibility(0);
      this.nIK.setImageResource(2131231497);
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
      this.nIM.invalidate();
      this.nIE = true;
      AppMethodBeat.o(113714);
      return;
      label751:
      i = 0;
      if (i < this.nIM.getChildCount())
      {
        localObject2 = this.nIM.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.nIM.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131306236);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131306235);
        if ((localObject1 != null) && (((r)localObject1).nvF))
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
        this.nIM.invalidate();
        break;
        label881:
        this.nIL.setVisibility(8);
        this.nIM.removeAllViews();
        break;
        if (!((g)localObject1).bLJ())
        {
          this.nIF.setVisibility(0);
          this.nIH.setVisibility(0);
          this.nII.setVisibility(0);
          this.nIJ.setVisibility(8);
          this.nIK.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bIb())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).bIb();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.nIH, (String)localObject1);
            localObject1 = this.nqt.getString(2131756990, new Object[] { l.Ro((String)localObject1) });
            this.nII.setText(com.tencent.mm.pluginsdk.ui.span.k.e(this.nqt, (CharSequence)localObject1, this.nqt.getResources().getDimensionPixelOffset(2131165517)));
          }
          this.nIE = true;
        }
        AppMethodBeat.o(113714);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */