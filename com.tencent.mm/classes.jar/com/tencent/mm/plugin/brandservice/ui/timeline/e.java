package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.m;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.b;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public final class e
  extends BaseAdapter
{
  private int dEb;
  private int gwE;
  List<z> nZr;
  aa.c pmx;
  private BizTimeLineNewMsgUI prY;
  private long prZ;
  boolean prk;
  boolean psa;
  
  public e(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<z> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.psa = false;
    this.pmx = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.NQE != aa.b.NQG) || (paramAnonymousa.psm == null)) {
            break label58;
          }
          e.a(e.this).add(0, paramAnonymousa.psm);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.NQE == aa.b.NQH)
          {
            paramAnonymousa = e.this;
            paramAnonymousObject = paramAnonymousa.cmo();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.nZr.clear();
              paramAnonymousa = paramAnonymousa.nZr;
              ae localae = com.tencent.mm.al.ag.bap();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(ae.o(localae.iFy.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.prk = false;
    this.prY = paramBizTimeLineNewMsgUI;
    com.tencent.mm.al.ag.bap().a(this.pmx, Looper.getMainLooper());
    this.nZr = paramList;
    this.gwE = paramInt1;
    this.dEb = paramInt2;
    this.prZ = paramLong;
    AppMethodBeat.o(5908);
  }
  
  private static void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(194916);
    if (ab.IT(paramString))
    {
      localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      paramImageView.setLayoutParams(localLayoutParams);
      a.b.d(paramImageView, paramString);
      AppMethodBeat.o(194916);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    paramImageView.setLayoutParams(localLayoutParams);
    a.b.c(paramImageView, paramString);
    AppMethodBeat.o(194916);
  }
  
  public final z De(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.nZr.size())
    {
      z localz = (z)this.nZr.get(paramInt);
      AppMethodBeat.o(5910);
      return localz;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void Df(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.gwE == 1) && (!this.psa))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.prk)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194915);
          Object localObject1;
          Object localObject2;
          if ((paramInt == e.this.getCount() - 1) && (!e.this.prk))
          {
            Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(e.this.getCount()) });
            localObject1 = e.this;
            localObject2 = ((e)localObject1).cmo();
            if (localObject2 == null) {
              break label243;
            }
            ae localae = com.tencent.mm.al.ag.bap();
            long l = ((z)localObject2).field_createTime;
            localObject2 = ae.o(localae.iFy.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((e)localObject1).nZr.addAll((Collection)localObject2);
            ((e)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label243;
            }
          }
          label243:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              e.this.prk = true;
              localObject1 = e.b(e.this);
              if (((BizTimeLineNewMsgUI)localObject1).psf != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).psj.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).psk.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).psk.findViewById(2131297570);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(2131756780));
                }
              }
            }
            AppMethodBeat.o(194915);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  public final z cmo()
  {
    AppMethodBeat.i(5912);
    if (this.nZr.size() > 0)
    {
      z localz = (z)this.nZr.get(this.nZr.size() - 1);
      AppMethodBeat.o(5912);
      return localz;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.nZr.size();
    AppMethodBeat.o(5909);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5911);
    z localz = De(paramInt);
    if (localz == null)
    {
      Log.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    paramViewGroup = localz.field_talker;
    int j = 0;
    a locala;
    View localView;
    label323:
    label340:
    Object localObject1;
    int i;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.prY, 2131493262, null);
      locala.aus = localView;
      locala.gyr = ((ImageView)localView.findViewById(2131297134));
      locala.kcZ = ((TextView)localView.findViewById(2131305433));
      paramView = d.pMy;
      d.i(locala.kcZ);
      locala.timeTv = ((TextView)localView.findViewById(2131309101));
      locala.titleTv = ((TextView)localView.findViewById(2131309249));
      locala.psc = ((TextView)localView.findViewById(2131309250));
      locala.obi = localView.findViewById(2131297683);
      locala.psd = ((ViewGroup)localView.findViewById(2131297502));
      locala.pse = ((AppBrandNearbyShowcaseView)localView.findViewById(2131297505));
      localView.setTag(locala);
      locala.psd.setVisibility(8);
      if (!localz.gAw()) {
        break label536;
      }
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localz.field_talker);
      if ((paramView != null) && (c.oR(paramView.field_type))) {
        break label569;
      }
      if (localz.gAB() != null)
      {
        paramView = new c.a();
        paramView.jbq = 2131231957;
        paramView.jbe = true;
        paramView.iaT = true;
        q.bcV().a(localz.gAB().iAR, locala.gyr, paramView.bdv());
      }
      if (!localz.gAw()) {
        break label585;
      }
      paramView = localz.gAB().nickName;
      locala.titleTv.setMaxLines(2147483647);
      locala.psc.setVisibility(8);
      locala.kcZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.prY, paramView, locala.kcZ.getTextSize()));
      locala.timeTv.setText(b.f(this.prY, localz.field_createTime));
      if (!localz.gAt()) {
        break label597;
      }
      localObject1 = m.HH(localz.field_content);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramView = this.prY.getString(2131756755);
      }
      locala.titleTv.setText(paramView);
      paramView = paramViewGroup;
      i = j;
      label460:
      if (paramInt != getCount() - 1) {
        break label1734;
      }
      locala.obi.setVisibility(4);
    }
    for (;;)
    {
      Df(paramInt);
      com.tencent.mm.storage.ag.a(paramView, 0, i, localz.field_msgId, paramInt, this.dEb, this.gwE - 1, (int)this.prZ);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label536:
      if (localz.gAx())
      {
        paramView = com.tencent.mm.storage.ag.I(localz);
        if (!Util.isNullOrNil(paramView))
        {
          a(locala.gyr, paramView);
          break label323;
        }
      }
      label569:
      a(locala.gyr, localz.field_talker);
      break label323;
      label585:
      paramView = aa.getDisplayName(localz.field_talker);
      break label340;
      label597:
      if (!localz.isText())
      {
        if (localz.field_type != 10000) {
          break label732;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = com.tencent.mm.storage.ag.i(localz, 0);
          if (!Util.isNullOrNil(paramView))
          {
            locala.titleTv.setText(paramView);
            com.tencent.mm.storage.ag.b(localz, 0, locala.titleTv);
            paramView = com.tencent.mm.storage.ag.i(localz, 1);
            if (!Util.isNullOrNil(paramView))
            {
              locala.psc.setText(paramView);
              locala.psc.setVisibility(0);
              com.tencent.mm.storage.ag.b(localz, 1, locala.psc);
              paramView = com.tencent.mm.storage.ag.L(localz);
              if (!Util.isNullOrNil(paramView)) {
                locala.kcZ.setText(paramView);
              }
            }
            paramView = paramViewGroup;
            i = j;
            break;
            label732:
            i = 0;
            continue;
          }
          locala.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this.prY, localz.field_content, (int)locala.titleTv.getTextSize()));
          paramView = paramViewGroup;
          i = j;
          break;
        }
      }
      if (localz.gAw())
      {
        locala.titleTv.setText(localz.gAB().title);
        paramView = paramViewGroup;
        i = j;
        break label460;
      }
      if (localz.gAz())
      {
        paramView = com.tencent.mm.storage.ag.i(localz, 0);
        if (!Util.isNullOrNil(paramView))
        {
          locala.titleTv.setText(paramView);
          com.tencent.mm.storage.ag.b(localz, 0, locala.titleTv);
          paramView = com.tencent.mm.storage.ag.i(localz, 1);
          if (!Util.isNullOrNil(paramView))
          {
            locala.psc.setText(paramView);
            locala.psc.setVisibility(0);
            com.tencent.mm.storage.ag.b(localz, 1, locala.psc);
          }
          paramView = com.tencent.mm.storage.ag.L(localz);
          if (!Util.isNullOrNil(paramView)) {
            locala.kcZ.setText(paramView);
          }
          paramView = paramViewGroup;
          i = j;
          break label460;
        }
        locala.titleTv.setText(this.prY.getString(2131755939));
        paramView = paramViewGroup;
        i = j;
        break label460;
      }
      if (localz.gAy())
      {
        locala.titleTv.setText(this.prY.getString(2131756022));
        paramView = paramViewGroup;
        i = j;
        break label460;
      }
      if (localz.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1038;
        }
        locala.titleTv.setText(this.prY.getString(2131756018));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1038:
      if ((localz.field_type == 42) || (localz.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1099;
        }
        locala.titleTv.setText(this.prY.getString(2131755949));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1099:
      Object localObject2;
      if (com.tencent.mm.storage.ag.J(localz))
      {
        locala.titleTv.setText(com.tencent.mm.storage.ag.h(localz, 0));
        com.tencent.mm.storage.ag.a(localz, 0, locala.titleTv);
        paramView = com.tencent.mm.storage.ag.h(localz, 1);
        if (!Util.isNullOrNil(paramView))
        {
          locala.psc.setText(paramView);
          locala.psc.setVisibility(0);
          com.tencent.mm.storage.ag.a(localz, 1, locala.psc);
        }
        p.h(localz, "info");
        paramView = "";
        localObject1 = com.tencent.mm.storage.ag.K(localz);
        if (localObject1 == null) {}
        for (;;)
        {
          if (!Util.isNullOrNil(paramView)) {
            locala.kcZ.setText(paramView);
          }
          paramView = com.tencent.mm.storage.ag.I(localz);
          i = com.tencent.mm.storage.ag.f(localz);
          break;
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.title2");
            paramView = paramViewGroup;
            if (paramViewGroup == null) {
              paramView = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramView).append(' ');
            paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.action");
            paramView = paramViewGroup;
            if (paramViewGroup == null) {
              paramView = "";
            }
            paramView = paramView;
          }
        }
      }
      if ((localz.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1336:
        if (i == 0) {
          break label1707;
        }
        localObject2 = k.b.HD(localz.field_content);
        if (localObject2 == null) {
          break label1707;
        }
        paramView = "";
        switch (((k.b)localObject2).type)
        {
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        if (Util.isNullOrNil(paramView)) {
          localObject1 = ((k.b)localObject2).getTitle();
        }
        locala.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.prY, (CharSequence)localObject1, locala.titleTv.getTextSize()));
        paramView = paramViewGroup;
        i = j;
        break;
        i = 0;
        break label1336;
        paramView = ((k.b)localObject2).title;
        continue;
        paramView = this.prY.getString(2131755939);
        continue;
        paramView = this.prY.getString(2131755905) + ((k.b)localObject2).title;
        continue;
        paramView = this.prY.getString(2131756018) + ((k.b)localObject2).title;
        continue;
        paramView = this.prY.getString(2131756012) + ((k.b)localObject2).getTitle();
        continue;
        paramView = this.prY.getString(2131755949) + ((k.b)localObject2).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject2).iyo + "]" + ((k.b)localObject2).iyk;
      }
      label1707:
      locala.titleTv.setText(this.prY.getString(2131756770));
      paramView = paramViewGroup;
      i = j;
      break label460;
      label1734:
      locala.obi.setVisibility(0);
    }
  }
  
  static final class a
  {
    View aus;
    ImageView gyr;
    TextView kcZ;
    View obi;
    TextView psc;
    ViewGroup psd;
    AppBrandNearbyShowcaseView pse;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e
 * JD-Core Version:    0.7.0.1
 */