package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ab.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.b;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  extends BaseAdapter
{
  private int dmM;
  private int fRv;
  List<com.tencent.mm.storage.w> mMj;
  x.c obB;
  private BizTimeLineNewMsgUI ogJ;
  private long ogK;
  boolean ogL;
  boolean ogw;
  
  public f(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<com.tencent.mm.storage.w> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.ogL = false;
    this.obB = new x.c()
    {
      public final void a(Object paramAnonymousObject, x.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.IIW != x.b.IIY) || (paramAnonymousa.ogW == null)) {
            break label58;
          }
          f.a(f.this).add(0, paramAnonymousa.ogW);
        }
        for (;;)
        {
          f.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.IIW == x.b.IIZ)
          {
            paramAnonymousa = f.this;
            paramAnonymousObject = paramAnonymousa.bPh();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.mMj.clear();
              paramAnonymousa = paramAnonymousa.mMj;
              z localz = ag.aGw();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(z.o(localz.hKK.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.ogw = false;
    this.ogJ = paramBizTimeLineNewMsgUI;
    ag.aGw().a(this.obB, Looper.getMainLooper());
    this.mMj = paramList;
    this.fRv = paramInt1;
    this.dmM = paramInt2;
    this.ogK = paramLong;
    AppMethodBeat.o(5908);
  }
  
  public final com.tencent.mm.storage.w bPh()
  {
    AppMethodBeat.i(5912);
    if (this.mMj.size() > 0)
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mMj.get(this.mMj.size() - 1);
      AppMethodBeat.o(5912);
      return localw;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.mMj.size();
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
    com.tencent.mm.storage.w localw = zz(paramInt);
    if (localw == null)
    {
      ae.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    paramViewGroup = localw.field_talker;
    int j = 0;
    a locala;
    View localView;
    label294:
    label311:
    Object localObject1;
    int i;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.ogJ, 2131493214, null);
      locala.auu = localView;
      locala.fTj = ((ImageView)localView.findViewById(2131297008));
      locala.jeW = ((TextView)localView.findViewById(2131302860));
      locala.timeTv = ((TextView)localView.findViewById(2131305822));
      locala.titleTv = ((TextView)localView.findViewById(2131305948));
      locala.mOh = localView.findViewById(2131297453);
      locala.ogN = ((ViewGroup)localView.findViewById(2131297299));
      locala.ogO = ((AppBrandNearbyShowcaseView)localView.findViewById(2131297302));
      localView.setTag(locala);
      locala.ogN.setVisibility(8);
      if (!localw.ftd()) {
        break label486;
      }
      paramView = ((l)g.ab(l.class)).azF().BH(localw.field_talker);
      if ((paramView != null) && (c.lO(paramView.field_type))) {
        break label519;
      }
      if (localw.fti() != null)
      {
        paramView = new c.a();
        paramView.igv = 2131231875;
        paramView.igj = true;
        paramView.hhW = true;
        q.aJb().a(localw.fti().hGI, locala.fTj, paramView.aJu());
      }
      if (!localw.ftd()) {
        break label535;
      }
      paramView = localw.fti().bVF;
      locala.jeW.setText(k.b(this.ogJ, paramView, locala.jeW.getTextSize()));
      locala.timeTv.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.ogJ, localw.field_createTime));
      if (!localw.fta()) {
        break label547;
      }
      localObject1 = m.zf(localw.field_content);
      paramView = (View)localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        paramView = this.ogJ.getString(2131756613);
      }
      locala.titleTv.setText(paramView);
      paramView = paramViewGroup;
      i = j;
      label410:
      if (paramInt != getCount() - 1) {
        break label1622;
      }
      locala.mOh.setVisibility(4);
    }
    for (;;)
    {
      zA(paramInt);
      ab.a(paramView, 0, i, localw.field_msgId, paramInt, this.dmM, this.fRv - 1, (int)this.ogK);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label486:
      if (localw.fte())
      {
        paramView = ab.v(localw);
        if (!bu.isNullOrNil(paramView))
        {
          a.b.d(locala.fTj, paramView);
          break label294;
        }
      }
      label519:
      a.b.d(locala.fTj, localw.field_talker);
      break label294;
      label535:
      paramView = com.tencent.mm.model.w.zP(localw.field_talker);
      break label311;
      label547:
      if (!localw.isText()) {
        if (localw.field_type != 10000) {
          break label612;
        }
      }
      label612:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label618;
        }
        locala.titleTv.setText(k.a(this.ogJ, localw.field_content, (int)locala.titleTv.getTextSize()));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label618:
      if (localw.ftd())
      {
        locala.titleTv.setText(localw.fti().title);
        paramView = paramViewGroup;
        i = j;
        break label410;
      }
      if (localw.ftg())
      {
        locala.titleTv.setText(this.ogJ.getString(2131755853));
        paramView = paramViewGroup;
        i = j;
        break label410;
      }
      if (localw.ftf())
      {
        locala.titleTv.setText(this.ogJ.getString(2131755929));
        paramView = paramViewGroup;
        i = j;
        break label410;
      }
      if (localw.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label772;
        }
        locala.titleTv.setText(this.ogJ.getString(2131755926));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label772:
      if ((localw.field_type == 42) || (localw.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label833;
        }
        locala.titleTv.setText(this.ogJ.getString(2131755860));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label833:
      Object localObject2;
      if (ab.x(localw))
      {
        paramViewGroup = locala.titleTv;
        p.h(localw, "info");
        localObject1 = new SpannableStringBuilder();
        localObject2 = ab.w(localw);
        if (localObject2 == null)
        {
          label876:
          paramViewGroup.setText((CharSequence)localObject1);
          p.h(localw, "info");
          paramView = "";
          paramViewGroup = ab.w(localw);
          if (paramViewGroup != null) {
            break label1179;
          }
        }
        for (;;)
        {
          if (!bu.isNullOrNil(paramView)) {
            locala.jeW.setText(paramView);
          }
          paramView = ab.v(localw);
          i = ab.d(localw);
          break;
          if ((localObject2 != null) && (bu.isNullOrNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.notify_msg.act")))) {
            break label876;
          }
          LinkedList localLinkedList = new LinkedList();
          d.g.a.b localb = (d.g.a.b)new ab.a((Map)localObject2);
          i = 0;
          if (i <= 10)
          {
            Object localObject3 = new StringBuilder(".msg.appmsg.mmreader.notify_msg.msg.item");
            if (i == 0) {}
            for (paramView = "";; paramView = Integer.valueOf(i))
            {
              paramView = paramView;
              if (bu.isNullOrNil((String)((Map)localObject2).get(paramView + ".content"))) {
                break label1138;
              }
              if (i > 0)
              {
                localObject3 = new SpannableString((CharSequence)" \n");
                ((SpannableString)localObject3).setSpan(new AbsoluteSizeSpan(4, true), 0, 2, 33);
                localLinkedList.add(localObject3);
              }
              localLinkedList.add(localb.invoke(paramView));
              i += 1;
              break;
            }
          }
          label1138:
          paramView = ((Iterable)localLinkedList).iterator();
          while (paramView.hasNext()) {
            ((SpannableStringBuilder)localObject1).append((CharSequence)paramView.next());
          }
          break label876;
          label1179:
          if (paramViewGroup != null)
          {
            paramViewGroup = (String)paramViewGroup.get(".msg.appmsg.mmreader.notify_msg.title");
            paramView = paramViewGroup;
            if (paramViewGroup == null) {
              paramView = "";
            }
          }
        }
      }
      if ((localw.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1226:
        if (i == 0) {
          break label1595;
        }
        localObject2 = k.b.zb(localw.field_content);
        if (localObject2 == null) {
          break label1595;
        }
        paramView = "";
        switch (((k.b)localObject2).type)
        {
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        if (bu.isNullOrNil(paramView)) {
          localObject1 = ((k.b)localObject2).getTitle();
        }
        locala.titleTv.setText(k.b(this.ogJ, (CharSequence)localObject1, locala.titleTv.getTextSize()));
        paramView = paramViewGroup;
        i = j;
        break;
        i = 0;
        break label1226;
        paramView = ((k.b)localObject2).title;
        continue;
        paramView = this.ogJ.getString(2131755853);
        continue;
        paramView = this.ogJ.getString(2131755820) + ((k.b)localObject2).title;
        continue;
        paramView = this.ogJ.getString(2131755926) + ((k.b)localObject2).title;
        continue;
        paramView = this.ogJ.getString(2131755920) + ((k.b)localObject2).getTitle();
        continue;
        paramView = this.ogJ.getString(2131755860) + ((k.b)localObject2).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject2).hEi + "]" + ((k.b)localObject2).hEe;
      }
      label1595:
      locala.titleTv.setText(this.ogJ.getString(2131756622));
      paramView = paramViewGroup;
      i = j;
      break label410;
      label1622:
      locala.mOh.setVisibility(0);
    }
  }
  
  public final void zA(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.fRv == 1) && (!this.ogL))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.ogw)) {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208453);
          Object localObject1;
          Object localObject2;
          if ((paramInt == f.this.getCount() - 1) && (!f.this.ogw))
          {
            ae.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(f.this.getCount()) });
            localObject1 = f.this;
            localObject2 = ((f)localObject1).bPh();
            if (localObject2 == null) {
              break label243;
            }
            z localz = ag.aGw();
            long l = ((com.tencent.mm.storage.w)localObject2).field_createTime;
            localObject2 = z.o(localz.hKK.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((f)localObject1).mMj.addAll((Collection)localObject2);
            ((f)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label243;
            }
          }
          label243:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              f.this.ogw = true;
              localObject1 = f.b(f.this);
              if (((BizTimeLineNewMsgUI)localObject1).ogP != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).ogT.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).ogU.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).ogU.findViewById(2131297358);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(2131756632));
                }
              }
            }
            AppMethodBeat.o(208453);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  public final com.tencent.mm.storage.w zz(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.mMj.size())
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mMj.get(paramInt);
      AppMethodBeat.o(5910);
      return localw;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  static final class a
  {
    View auu;
    ImageView fTj;
    TextView jeW;
    View mOh;
    ViewGroup ogN;
    AppBrandNearbyShowcaseView ogO;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */