package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  implements h.c, k.a
{
  private Context context;
  private String egT;
  private d ocL;
  private ViewGroup odk;
  private View odl;
  private h odm;
  private j odn;
  private ArrayList<String> odo;
  private String odp;
  private boolean odq;
  public i.a odr;
  
  public i(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(113512);
    this.odp = "";
    this.egT = "";
    this.odq = false;
    this.odk = paramViewGroup;
    this.odl = paramView;
    this.context = paramContext;
    this.odo = new ArrayList();
    this.egT = paramString;
    this.ocL = paramd;
    init();
    AppMethodBeat.o(113512);
  }
  
  private void init()
  {
    AppMethodBeat.i(113513);
    ab.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.egT });
    this.odm = new h(this.context, this.odl, this.egT);
    this.odm.odc = this;
    this.odn = new j(this.context, this.odk, this.egT);
    Iterator localIterator = l.bLs().uN(this.egT).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.odo.add(str);
    }
    AppMethodBeat.o(113513);
  }
  
  public final void H(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(113514);
    ab.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.odm.H(paramArrayList);
    j localj = this.odn;
    ab.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localj.odt.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localj.odt.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localj.odF)
    {
      localj.odF = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localj.odt.add(localObject1);
        }
      }
      localj.iS(false);
      AppMethodBeat.o(113514);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localj.odt.add(paramArrayList);
      if (!bo.isNullOrNil(s.nE(paramArrayList)))
      {
        localj.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localj.mHandler.sendMessage((Message)localObject2);
        localj.iS(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!bo.isNullOrNil(paramArrayList)) && (localj.odt.indexOf(paramArrayList) != -1))
      {
        localj.odt.remove(localj.odt.indexOf(paramArrayList));
        if (!bo.isNullOrNil(s.nE(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localj.mHandler.sendMessage((Message)localObject1);
          localj.iS(true);
        }
      }
    }
    AppMethodBeat.o(113514);
  }
  
  public final void Sh(String paramString)
  {
    AppMethodBeat.i(113515);
    if (this.odr != null) {
      this.odr.Sh(paramString);
    }
    AppMethodBeat.o(113515);
  }
  
  public final void Si(String paramString)
  {
    AppMethodBeat.i(113517);
    ab.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.odq)
    {
      AppMethodBeat.o(113517);
      return;
    }
    this.odp = paramString;
    paramString = this.odm;
    Object localObject = this.odp;
    ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      paramString.bLK();
      paramString = this.odn;
      localObject = this.odp;
      ab.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bo.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!bo.isNullOrNil(s.nE((String)localObject)))
      {
        paramString.odK = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.iS(true);
    }
    for (;;)
    {
      paramString = this.ocL.getViewByItag(this.odp);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(113517);
      return;
      paramString.bLK();
      paramString.Se((String)localObject);
      break;
      label203:
      paramString.odK = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.iS(true);
    }
  }
  
  public final void Sj(String paramString)
  {
    AppMethodBeat.i(113520);
    j localj = this.odn;
    ab.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(s.nE(paramString))))
    {
      localj.odK = true;
      localj.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localj.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(113520);
  }
  
  public final void bLO()
  {
    AppMethodBeat.i(113516);
    ab.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.odq = true;
    String str = r.Zn();
    this.odm.bLK();
    this.odm.Se(str);
    Object localObject = this.odn;
    ab.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((j)localObject).mHandler.removeMessages(6);
    ((j)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((j)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.ocL.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.odp = str;
    AppMethodBeat.o(113516);
  }
  
  public final void bLP()
  {
    AppMethodBeat.i(113518);
    ab.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.odm;
    Object localObject2 = r.Zn();
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((h)localObject1).oda.Sg((String)localObject2))
    {
      ((h)localObject1).oda.Sf((String)localObject2).bLN();
      ((h)localObject1).oda.notifyDataSetChanged();
      ((h)localObject1).ocZ.invalidate();
    }
    localObject1 = this.odn;
    ab.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((j)localObject1).mHandler.removeMessages(9);
    ((j)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((j)localObject1).mHandler.sendMessage((Message)localObject2);
    this.odp = "";
    this.odq = false;
    AppMethodBeat.o(113518);
  }
  
  public final void bLQ()
  {
    AppMethodBeat.i(113519);
    j localj = this.odn;
    ab.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localj.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localj.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(113519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */