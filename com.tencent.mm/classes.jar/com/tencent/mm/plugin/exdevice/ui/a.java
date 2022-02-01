package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.exdevice.g.a.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a
  extends BaseAdapter
{
  String lJm;
  private String mAppName;
  private Context mContext;
  c qrp;
  private boolean qrq;
  boolean qrr;
  int qrs;
  int qrt;
  ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qru;
  List<re> qrv;
  private View qrw;
  
  public a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.lJm = paramString2;
    this.qrq = paramBoolean;
    this.mAppName = paramString1;
  }
  
  public final int getCount()
  {
    if (this.qrq) {
      return this.qrs + 5 + this.qrt;
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
    if (!this.qrq) {
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
    if ((paramInt > 1) && (paramInt <= this.qrs + 1)) {
      return 1;
    }
    if (paramInt == this.qrs + 2) {
      return 2;
    }
    if (paramInt == this.qrs + 3) {
      return 5;
    }
    if ((paramInt > this.qrs + 3) && (paramInt <= this.qrs + 3 + this.qrt)) {
      return 3;
    }
    if (paramInt == this.qrs + this.qrt + 4) {
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
      if (this.qrw == null) {
        this.qrw = LayoutInflater.from(this.mContext).inflate(2131493877, paramViewGroup, false);
      }
      paramView = this.qrw;
      localf = new f();
      localf.pjj = ((ImageView)paramView.findViewById(2131299556));
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
      locale.qrC = ((NoMeasuredTextView)paramView.findViewById(2131299579));
      locale.qrD = ((TextView)paramView.findViewById(2131299580));
      locale.pjj = ((ImageView)paramView.findViewById(2131299574));
      locale.qry = paramView.findViewById(2131299577);
      locale.qrC.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
      locale.qrC.setTextColor(this.mContext.getResources().getColor(2131100308));
      locale.qrC.setSingleLine(true);
      locale.qrC.setShouldEllipsize(true);
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
      locala.jdField_new = ((TextView)paramView.findViewById(2131299565));
      locala.qry = paramView.findViewById(2131299562);
      locala.qox = ((ImageView)paramView.findViewById(2131299563));
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
      localc.jdField_new = ((TextView)paramView.findViewById(2131299565));
      localc.qry = paramView.findViewById(2131299562);
      localc.qox = ((ImageView)paramView.findViewById(2131299563));
      localc.qrA = paramView.findViewById(2131299561);
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
      locald.qrB = ((Button)paramView.findViewById(2131299570));
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
      ((b)localObject).jdField_new = ((TextView)paramView.findViewById(2131299569));
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
      paramViewGroup.qrz = paramView.findViewById(2131299568);
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
        com.tencent.mm.pluginsdk.ui.a.b.v(localf.pjj, this.lJm);
        localf.pjj.setOnClickListener(new a.1(this));
        continue;
        if ((paramInt - 2 >= 0) && (!bu.ht(this.qru)))
        {
          paramViewGroup = (com.tencent.mm.plugin.exdevice.g.b.a.c)this.qru.get(paramInt - 2);
          if (paramViewGroup != null)
          {
            paramInt = paramViewGroup.field_step;
            localObject = paramViewGroup.field_username;
            if (paramViewGroup.field_step >= 10000) {
              locale.qrD.setTextColor(this.mContext.getResources().getColor(2131100307));
            }
            for (;;)
            {
              locale.qrC.setText(k.b(this.mContext, w.zP((String)localObject), locale.qrC.getTextSize()));
              locale.qrD.setText(String.valueOf(paramInt));
              com.tencent.mm.pluginsdk.ui.a.b.d(locale.pjj, (String)localObject);
              locale.qry.setOnClickListener(new a.2(this, (String)localObject));
              break;
              locale.qrD.setTextColor(this.mContext.getResources().getColor(2131100306));
            }
            locala.jdField_new.setText(this.mContext.getResources().getText(2131758569));
            locala.qox.setImageDrawable(ao.k(this.mContext, 2131690051, this.mContext.getResources().getColor(2131099732)));
            locala.qry.setOnClickListener(new a.3(this));
            continue;
            if ((paramInt - this.qrs - 4 >= 0) && (!bu.ht(this.qrv)))
            {
              localObject = (re)this.qrv.get(paramInt - this.qrs - 4);
              if (localObject != null)
              {
                paramViewGroup = ((re)localObject).title;
                localObject = ((re)localObject).dEM;
                localc.jdField_new.setText(paramViewGroup);
                if (paramInt - this.qrs - 4 != this.qrt - 1) {
                  localc.qrA.setVisibility(0);
                }
                e.a(this.mContext, localc.qox, (String)localObject);
                localc.qry.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(24075);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    com.tencent.mm.plugin.sport.a.c.md(8);
                    paramAnonymousView = new AppBrandStatObject();
                    paramAnonymousView.scene = 1063;
                    ((p)g.ab(p.class)).a(a.b(a.this), null, "wx3fca79fc5715b185", 0, 0, "", paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(24075);
                  }
                });
                continue;
                if (!this.qrr)
                {
                  bc.aCg();
                  if (com.tencent.mm.model.c.azF().aUH(this.lJm))
                  {
                    locald.qrB.setVisibility(0);
                    locald.qrB.setOnClickListener(new a.5(this));
                    continue;
                  }
                }
                locald.qrB.setVisibility(4);
                continue;
                ((b)localObject).jdField_new.setText(this.mContext.getString(2131758578));
                continue;
                paramViewGroup.qrz.setVisibility(0);
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
    TextView jdField_new;
    ImageView qox;
    View qry;
    
    a() {}
  }
  
  final class b
  {
    TextView jdField_new;
    View qrz;
    
    b() {}
  }
  
  final class c
  {
    TextView jdField_new;
    ImageView qox;
    View qrA;
    View qry;
    
    c() {}
  }
  
  final class d
  {
    Button qrB;
    
    d() {}
  }
  
  final class e
  {
    ImageView pjj;
    NoMeasuredTextView qrC;
    TextView qrD;
    View qry;
    
    e() {}
  }
  
  final class f
  {
    ImageView pjj;
    
    f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */