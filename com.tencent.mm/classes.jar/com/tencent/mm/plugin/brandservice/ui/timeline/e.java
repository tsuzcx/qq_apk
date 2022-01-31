package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import java.util.List;

public final class e
  extends BaseAdapter
{
  private int ejF;
  List<q> iQp;
  r.c jSD;
  boolean jVY;
  private BizTimeLineNewMsgUI jWl;
  boolean jWm;
  
  public e(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<q> paramList, int paramInt)
  {
    AppMethodBeat.i(14149);
    this.jWm = false;
    this.jSD = new e.1(this);
    this.jVY = false;
    this.jWl = paramBizTimeLineNewMsgUI;
    z.afp().a(this.jSD, Looper.getMainLooper());
    this.iQp = paramList;
    this.ejF = paramInt;
    AppMethodBeat.o(14149);
  }
  
  public final q aWH()
  {
    AppMethodBeat.i(14153);
    if (this.iQp.size() > 0)
    {
      q localq = (q)this.iQp.get(this.iQp.size() - 1);
      AppMethodBeat.o(14153);
      return localq;
    }
    AppMethodBeat.o(14153);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(14150);
    int i = this.iQp.size();
    AppMethodBeat.o(14150);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(14152);
    Object localObject = se(paramInt);
    if (localObject == null)
    {
      ab.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(14152);
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.jWl, 2130968878, null);
      paramViewGroup.ehv = ((ImageView)localView.findViewById(2131821210));
      paramViewGroup.gvQ = ((TextView)localView.findViewById(2131821854));
      paramViewGroup.timeTv = ((TextView)localView.findViewById(2131821004));
      paramViewGroup.titleTv = ((TextView)localView.findViewById(2131821212));
      paramViewGroup.iSi = localView.findViewById(2131821855);
      localView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.ehv, ((q)localObject).field_talker);
      paramView = s.nE(((q)localObject).field_talker);
      paramViewGroup.gvQ.setText(j.b(this.jWl, paramView, paramViewGroup.gvQ.getTextSize()));
      paramViewGroup.timeTv.setText(b.e(this.jWl, ((q)localObject).field_createTime));
      if (!((q)localObject).dvV()) {
        break label285;
      }
      localObject = l.nc(((q)localObject).field_content);
      paramView = (View)localObject;
      if (bo.isNullOrNil((String)localObject)) {
        paramView = this.jWl.getString(2131297697);
      }
      paramViewGroup.titleTv.setText(paramView);
      label239:
      if (paramInt != getCount() - 1) {
        break label892;
      }
      paramViewGroup.iSi.setVisibility(4);
    }
    for (;;)
    {
      sf(paramInt);
      AppMethodBeat.o(14152);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label285:
      if (!((q)localObject).isText()) {
        if (((q)localObject).field_type != 10000) {
          break label342;
        }
      }
      label342:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label348;
        }
        paramViewGroup.titleTv.setText(j.a(this.jWl, ((q)localObject).field_content, (int)paramViewGroup.titleTv.getTextSize()));
        break;
      }
      label348:
      if (((q)localObject).dvX())
      {
        paramViewGroup.titleTv.setText(this.jWl.getString(2131297036));
        break label239;
      }
      if (((q)localObject).dvW())
      {
        paramViewGroup.titleTv.setText(this.jWl.getString(2131297105));
        break label239;
      }
      if (((q)localObject).field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label445;
        }
        paramViewGroup.titleTv.setText(this.jWl.getString(2131297102));
        break;
      }
      label445:
      if ((((q)localObject).field_type == 42) || (((q)localObject).field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label498;
        }
        paramViewGroup.titleTv.setText(this.jWl.getString(2131297043));
        break;
      }
      label498:
      j.b localb;
      if ((((q)localObject).field_type & 0xFFFF) == 49)
      {
        i = 1;
        label514:
        if (i == 0) {
          break label872;
        }
        localb = j.b.mY(((q)localObject).field_content);
        if (localb == null) {
          break label872;
        }
        paramView = "";
        switch (localb.type)
        {
        }
      }
      for (;;)
      {
        localObject = paramView;
        if (bo.isNullOrNil(paramView)) {
          localObject = localb.getTitle();
        }
        paramViewGroup.titleTv.setText(j.b(this.jWl, (CharSequence)localObject, paramViewGroup.titleTv.getTextSize()));
        break;
        i = 0;
        break label514;
        paramView = localb.title;
        continue;
        paramView = this.jWl.getString(2131297036);
        continue;
        paramView = this.jWl.getString(2131297003) + localb.title;
        continue;
        paramView = this.jWl.getString(2131297102) + localb.title;
        continue;
        paramView = this.jWl.getString(2131297097) + localb.getTitle();
        continue;
        paramView = this.jWl.getString(2131297043) + localb.getTitle();
        continue;
        paramView = "[" + localb.fie + "]" + localb.fia;
      }
      label872:
      paramViewGroup.titleTv.setText(this.jWl.getString(2131297706));
      break label239;
      label892:
      paramViewGroup.iSi.setVisibility(0);
    }
  }
  
  public final q se(int paramInt)
  {
    AppMethodBeat.i(14151);
    if (paramInt < this.iQp.size())
    {
      q localq = (q)this.iQp.get(paramInt);
      AppMethodBeat.o(14151);
      return localq;
    }
    AppMethodBeat.o(14151);
    return null;
  }
  
  public final void sf(int paramInt)
  {
    AppMethodBeat.i(14154);
    if ((this.ejF == 1) && (!this.jWm))
    {
      AppMethodBeat.o(14154);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.jVY)) {
      al.p(new e.2(this, paramInt), 300L);
    }
    AppMethodBeat.o(14154);
  }
  
  static final class a
  {
    ImageView ehv;
    TextView gvQ;
    View iSi;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e
 * JD-Core Version:    0.7.0.1
 */