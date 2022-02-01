package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  implements f.c, i.a
{
  private Context context;
  private String fQB;
  private ViewGroup vcS;
  private View vcT;
  private f vcU;
  private h vcV;
  private ArrayList<String> vcW;
  private String vcX;
  private boolean vcY;
  private d vcZ;
  public a vda;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.vcX = "";
    this.fQB = "";
    this.vcY = false;
    this.vcS = paramViewGroup;
    this.vcT = paramView;
    this.context = paramContext;
    this.vcW = new ArrayList();
    this.fQB = paramString;
    this.vcZ = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    ad.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.fQB });
    this.vcU = new f(this.context, this.vcT, this.fQB);
    this.vcU.vcK = this;
    this.vcV = new h(this.context, this.vcS, this.fQB);
    Iterator localIterator = n.dgi().GJ(this.fQB).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.vcW.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    ad.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.vcU.ai(paramArrayList);
    h localh = this.vcV;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.hbS.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.hbS.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.vdn)
    {
      localh.vdn = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.hbS.add(localObject1);
        }
      }
      localh.nU(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.hbS.add(paramArrayList);
      if (!bt.isNullOrNil(v.zf(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.nU(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!bt.isNullOrNil(paramArrayList)) && (localh.hbS.indexOf(paramArrayList) != -1))
      {
        localh.hbS.remove(localh.hbS.indexOf(paramArrayList));
        if (!bt.isNullOrNil(v.zf(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.nU(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void aoI(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.vda != null) {
      this.vda.aoI(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void aoJ(String paramString)
  {
    AppMethodBeat.i(55918);
    ad.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.vcY)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.vcX = paramString;
    paramString = this.vcU;
    Object localObject = this.vcX;
    ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      paramString.dgC();
      paramString = this.vcV;
      localObject = this.vcX;
      ad.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bt.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!bt.isNullOrNil(v.zf((String)localObject)))
      {
        paramString.vds = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.nU(true);
    }
    for (;;)
    {
      paramString = this.vcZ.getViewByItag(this.vcX);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.dgC();
      paramString.aoF((String)localObject);
      break;
      label203:
      paramString.vds = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.nU(true);
    }
  }
  
  public final void aoK(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.vcV;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(v.zf(paramString))))
    {
      localh.vds = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void dgG()
  {
    AppMethodBeat.i(55917);
    ad.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.vcY = true;
    String str = u.aAm();
    this.vcU.dgC();
    this.vcU.aoF(str);
    Object localObject = this.vcV;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.vcZ.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.vcX = str;
    AppMethodBeat.o(55917);
  }
  
  public final void dgH()
  {
    AppMethodBeat.i(55919);
    ad.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.vcU;
    Object localObject2 = u.aAm();
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).vcI.aoH((String)localObject2))
    {
      ((f)localObject1).vcI.aoG((String)localObject2).dgF();
      ((f)localObject1).vcI.notifyDataSetChanged();
      ((f)localObject1).vcH.invalidate();
    }
    localObject1 = this.vcV;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.vcX = "";
    this.vcY = false;
    AppMethodBeat.o(55919);
  }
  
  public final void dgI()
  {
    AppMethodBeat.i(55920);
    h localh = this.vcV;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void aoI(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */