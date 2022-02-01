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
  MMActivity nTt;
  private boolean olE;
  private View olF;
  private View olG;
  private ImageView olH;
  private TextView olI;
  private TextView olJ;
  private ImageView olK;
  View olL;
  private LinearLayout olM;
  private View.OnClickListener olN;
  
  public x()
  {
    AppMethodBeat.i(113712);
    this.olE = false;
    this.olN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113711);
        if (!(paramAnonymousView.getTag() instanceof r))
        {
          AppMethodBeat.o(113711);
          return;
        }
        Object localObject = x.this.olg.bRG();
        x.this.olg.bRI();
        paramAnonymousView = (r)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.nYE == null) || (paramAnonymousView.nYE.isEmpty()))
        {
          AppMethodBeat.o(113711);
          return;
        }
        if ((paramAnonymousView.nYC != null) && (paramAnonymousView.nYC.equals(((com.tencent.mm.plugin.card.base.b)localObject).bPo())))
        {
          x.this.olL.setVisibility(8);
          x.this.olg.bQT();
          AppMethodBeat.o(113711);
          return;
        }
        if ((TextUtils.isEmpty(paramAnonymousView.nYC)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bPo())))
        {
          x.this.olL.setVisibility(8);
          x.this.olg.bQT();
          AppMethodBeat.o(113711);
          return;
        }
        localObject = com.tencent.mm.plugin.card.sharecard.a.b.UO(paramAnonymousView.nUr);
        int k;
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int j = 0;
          int i = 0;
          k = i;
          if (j < ((ArrayList)localObject).size())
          {
            r localr = (r)((ArrayList)localObject).get(j);
            if (((localr.nYC != null) && (localr.nYC.equals(paramAnonymousView.nYC))) || ((TextUtils.isEmpty(localr.nYC)) && (TextUtils.isEmpty(paramAnonymousView.nYC))))
            {
              localr.nYF = true;
              if (!localr.nYG)
              {
                localr.nYG = true;
                i = 1;
              }
              ((ArrayList)localObject).set(j, localr);
            }
            for (;;)
            {
              j += 1;
              break;
              localr.nYF = false;
              ((ArrayList)localObject).set(j, localr);
            }
          }
        }
        else
        {
          k = 0;
        }
        paramAnonymousView = (String)paramAnonymousView.nYE.get(0);
        paramAnonymousView = am.bQq().UV(paramAnonymousView);
        if (paramAnonymousView != null) {
          x.this.olg.b(paramAnonymousView);
        }
        if ((k != 0) && (x.this.olg.bRM() != null)) {
          x.this.olg.bRM().bRz();
        }
        x.this.olL.setVisibility(8);
        AppMethodBeat.o(113711);
      }
    };
    AppMethodBeat.o(113712);
  }
  
  public final void bTM()
  {
    AppMethodBeat.i(113715);
    this.olF.setVisibility(8);
    AppMethodBeat.o(113715);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113713);
    this.olF = findViewById(2131304760);
    this.olG = findViewById(2131304762);
    this.olH = ((ImageView)findViewById(2131304754));
    this.olI = ((TextView)findViewById(2131304755));
    this.olJ = ((TextView)findViewById(2131304757));
    this.olK = ((ImageView)findViewById(2131304756));
    this.olF.setVisibility(8);
    this.olL = findViewById(2131304758);
    this.olM = ((LinearLayout)findViewById(2131304759));
    this.olL.setVisibility(8);
    this.nTt = this.olg.bRJ();
    AppMethodBeat.o(113713);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113714);
    Object localObject4 = this.olg.bRG();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.UO(((com.tencent.mm.plugin.card.base.b)localObject4).bPn());
    Object localObject1 = this.olg.bRL();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).bSW())
    {
      this.olF.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.UN(((com.tencent.mm.plugin.card.base.b)localObject4).bPn()) > 1) {
        this.olG.setOnClickListener(this.olg.bRK());
      }
      for (;;)
      {
        localObject4 = this.olg.bRG();
        if (!this.olg.bRH()) {
          break;
        }
        this.olH.setVisibility(8);
        this.olI.setVisibility(8);
        this.olJ.setVisibility(0);
        this.olK.setImageResource(2131231498);
        this.olJ.setText(this.nTt.getString(2131756985));
        if (!this.olg.bRH()) {
          break label881;
        }
        this.olL.setVisibility(0);
        if ((this.olM.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.nTt.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2131495431, this.olM, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131306234);
          localObject5 = (TextView)((View)localObject4).findViewById(2131306243);
          localObject6 = (TextView)((View)localObject4).findViewById(2131304738);
          if (!TextUtils.isEmpty(((r)localObject3).nYC))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).nYC);
            localObject7 = l.VA(((r)localObject3).nYC);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.nTt, (CharSequence)localObject7, this.nTt.getResources().getDimensionPixelOffset(2131165576)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).nYD);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.olN);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131306236);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131306235);
          if (!((r)localObject3).nYF) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.olM.addView((View)localObject4);
        }
        this.olK.setVisibility(8);
        this.olL.setVisibility(8);
        this.olM.removeAllViews();
        this.olg.bRI();
      }
      this.olH.setVisibility(0);
      this.olI.setVisibility(0);
      this.olJ.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.UN(((com.tencent.mm.plugin.card.base.b)localObject4).bPn()) <= 1)
      {
        this.olK.setVisibility(8);
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
        if (!((r)localObject1).nYF) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).nYC;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bPo())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).bPo();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.olH, (String)localObject2);
      localObject1 = this.nTt.getString(2131756990, new Object[] { l.VA((String)localObject2) });
      this.olI.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.nTt, (CharSequence)localObject1, this.nTt.getResources().getDimensionPixelOffset(2131165517)));
      break;
      this.olK.setVisibility(0);
      this.olK.setImageResource(2131231497);
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
      this.olM.invalidate();
      this.olE = true;
      AppMethodBeat.o(113714);
      return;
      label751:
      i = 0;
      if (i < this.olM.getChildCount())
      {
        localObject2 = this.olM.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.olM.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131306236);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131306235);
        if ((localObject1 != null) && (((r)localObject1).nYF))
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
        this.olM.invalidate();
        break;
        label881:
        this.olL.setVisibility(8);
        this.olM.removeAllViews();
        break;
        if (!((g)localObject1).bSW())
        {
          this.olF.setVisibility(0);
          this.olH.setVisibility(0);
          this.olI.setVisibility(0);
          this.olJ.setVisibility(8);
          this.olK.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bPo())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).bPo();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.olH, (String)localObject1);
            localObject1 = this.nTt.getString(2131756990, new Object[] { l.VA((String)localObject1) });
            this.olI.setText(com.tencent.mm.pluginsdk.ui.span.k.f(this.nTt, (CharSequence)localObject1, this.nTt.getResources().getDimensionPixelOffset(2131165517)));
          }
          this.olE = true;
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