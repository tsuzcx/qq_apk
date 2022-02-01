package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.exdevice.g.a.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a
  extends BaseAdapter
{
  String lhM;
  private String mAppName;
  private Context mContext;
  c pHf;
  private boolean pHg;
  boolean pHh;
  int pHi;
  int pHj;
  ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> pHk;
  List<px> pHl;
  private View pHm;
  
  public a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.lhM = paramString2;
    this.pHg = paramBoolean;
    this.mAppName = paramString1;
  }
  
  public final int getCount()
  {
    if (this.pHg) {
      return this.pHi + 5 + this.pHj;
    }
    return 2;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(24077);
    AppMethodBeat.o(24077);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (!this.pHg) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 4;
    }
    if (paramInt == 1) {
      return 6;
    }
    if ((paramInt > 1) && (paramInt <= this.pHi + 1)) {
      return 1;
    }
    if (paramInt == this.pHi + 2) {
      return 2;
    }
    if (paramInt == this.pHi + 3) {
      return 5;
    }
    if ((paramInt > this.pHi + 3) && (paramInt <= this.pHi + 3 + this.pHj)) {
      return 3;
    }
    if (paramInt == this.pHi + this.pHj + 4) {
      return 7;
    }
    return 5;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24078);
    int i = getItemViewType(paramInt);
    Object localObject;
    c localc;
    a locala;
    d locald;
    e locale;
    f localf;
    if (paramView == null) {
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24078);
      return paramView;
      if (this.pHm == null) {
        this.pHm = LayoutInflater.from(this.mContext).inflate(2131493877, paramViewGroup, false);
      }
      paramView = this.pHm;
      localf = new f();
      localf.ozi = ((ImageView)paramView.findViewById(2131299556));
      paramView.setTag(localf);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493876, paramViewGroup, false);
      locale = new e();
      locale.pHs = ((NoMeasuredTextView)paramView.findViewById(2131299579));
      locale.pHt = ((TextView)paramView.findViewById(2131299580));
      locale.ozi = ((ImageView)paramView.findViewById(2131299574));
      locale.pHo = paramView.findViewById(2131299577);
      locale.pHs.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
      locale.pHs.setTextColor(this.mContext.getResources().getColor(2131100308));
      locale.pHs.setSingleLine(true);
      locale.pHs.setShouldEllipsize(true);
      paramView.setTag(locale);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493872, paramViewGroup, false);
      locala = new a();
      locala.myG = ((TextView)paramView.findViewById(2131299565));
      locala.pHo = paramView.findViewById(2131299562);
      locala.pEn = ((ImageView)paramView.findViewById(2131299563));
      paramView.setTag(locala);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493872, paramViewGroup, false);
      localc = new c();
      localc.myG = ((TextView)paramView.findViewById(2131299565));
      localc.pHo = paramView.findViewById(2131299562);
      localc.pEn = ((ImageView)paramView.findViewById(2131299563));
      localc.pHq = paramView.findViewById(2131299561);
      paramView.setTag(localc);
      paramViewGroup = null;
      localObject = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493875, paramViewGroup, false);
      locald = new d();
      locald.pHr = ((Button)paramView.findViewById(2131299570));
      paramView.setTag(locald);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493874, paramViewGroup, false);
      paramView.setTag(new b());
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493874, paramViewGroup, false);
      localObject = new b();
      ((b)localObject).myG = ((TextView)paramView.findViewById(2131299569));
      paramView.setTag(localObject);
      paramViewGroup = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2131493874, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.pHp = paramView.findViewById(2131299568);
      paramView.setTag(paramViewGroup);
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 0: 
        localf = (f)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        break;
      case 1: 
        locale = (e)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        localf = null;
        break;
      case 2: 
        locala = (a)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 3: 
        localc = (c)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 4: 
        locald = (d)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locale = null;
        localf = null;
        break;
      case 5: 
        paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 6: 
        localObject = (b)paramView.getTag();
        paramViewGroup = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 7: 
        paramViewGroup = (b)paramView.getTag();
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
        com.tencent.mm.pluginsdk.ui.a.b.v(localf.ozi, this.lhM);
        localf.ozi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24072);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", a.a(a.this));
            d.b(a.b(a.this), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            AppMethodBeat.o(24072);
          }
        });
        continue;
        if ((paramInt - 2 >= 0) && (!bs.gY(this.pHk)))
        {
          paramViewGroup = (com.tencent.mm.plugin.exdevice.g.b.a.c)this.pHk.get(paramInt - 2);
          if (paramViewGroup != null)
          {
            paramInt = paramViewGroup.field_step;
            localObject = paramViewGroup.field_username;
            if (paramViewGroup.field_step >= 10000) {
              locale.pHt.setTextColor(this.mContext.getResources().getColor(2131100307));
            }
            for (;;)
            {
              locale.pHs.setText(k.b(this.mContext, v.wk((String)localObject), locale.pHs.getTextSize()));
              locale.pHt.setText(String.valueOf(paramInt));
              com.tencent.mm.pluginsdk.ui.a.b.d(locale.ozi, (String)localObject);
              locale.pHo.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(24073);
                  paramAnonymousView = a.b(a.this);
                  Object localObject = new Intent(paramAnonymousView, ExdeviceProfileUI.class);
                  ((Intent)localObject).putExtra("username", this.hyc);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(24073);
                }
              });
              break;
              locale.pHt.setTextColor(this.mContext.getResources().getColor(2131100306));
            }
            locala.myG.setText(this.mContext.getResources().getText(2131758569));
            locala.pEn.setImageDrawable(am.k(this.mContext, 2131690051, this.mContext.getResources().getColor(2131099732)));
            locala.pHo.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(24074);
                if (a.c(a.this) != null)
                {
                  paramAnonymousView = a.c(a.this);
                  a.a(a.this);
                  paramAnonymousView.chL();
                }
                AppMethodBeat.o(24074);
              }
            });
            continue;
            if ((paramInt - this.pHi - 4 >= 0) && (!bs.gY(this.pHl)))
            {
              localObject = (px)this.pHl.get(paramInt - this.pHi - 4);
              if (localObject != null)
              {
                paramViewGroup = ((px)localObject).title;
                localObject = ((px)localObject).drM;
                localc.myG.setText(paramViewGroup);
                if (paramInt - this.pHi - 4 != this.pHj - 1) {
                  localc.pHq.setVisibility(0);
                }
                e.a(this.mContext, localc.pEn, (String)localObject);
                localc.pHo.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(24075);
                    com.tencent.mm.plugin.sport.a.c.lA(8);
                    paramAnonymousView = new AppBrandStatObject();
                    paramAnonymousView.scene = 1063;
                    ((n)g.ab(n.class)).a(a.b(a.this), null, "wx3fca79fc5715b185", 0, 0, "", paramAnonymousView);
                    AppMethodBeat.o(24075);
                  }
                });
                continue;
                if (!this.pHh)
                {
                  az.ayM();
                  if (com.tencent.mm.model.c.awB().aNo(this.lhM))
                  {
                    locald.pHr.setVisibility(0);
                    locald.pHr.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(24076);
                        if (a.c(a.this) != null)
                        {
                          paramAnonymousView = a.c(a.this);
                          a.a(a.this);
                          paramAnonymousView.chM();
                        }
                        AppMethodBeat.o(24076);
                      }
                    });
                    continue;
                  }
                }
                locald.pHr.setVisibility(4);
                continue;
                ((b)localObject).myG.setText(this.mContext.getString(2131758578));
                continue;
                paramViewGroup.pHp.setVisibility(0);
              }
            }
          }
        }
        break;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 8;
  }
  
  final class a
  {
    TextView myG;
    ImageView pEn;
    View pHo;
    
    a() {}
  }
  
  final class b
  {
    TextView myG;
    View pHp;
    
    b() {}
  }
  
  final class c
  {
    TextView myG;
    ImageView pEn;
    View pHo;
    View pHq;
    
    c() {}
  }
  
  final class d
  {
    Button pHr;
    
    d() {}
  }
  
  final class e
  {
    ImageView ozi;
    View pHo;
    NoMeasuredTextView pHs;
    TextView pHt;
    
    e() {}
  }
  
  final class f
  {
    ImageView ozi;
    
    f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */