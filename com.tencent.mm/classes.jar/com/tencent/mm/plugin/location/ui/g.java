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
  private String ftH;
  private ViewGroup sRW;
  private View sRX;
  private f sRY;
  private h sRZ;
  private ArrayList<String> sSa;
  private String sSb;
  private boolean sSc;
  private d sSd;
  public a sSe;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.sSb = "";
    this.ftH = "";
    this.sSc = false;
    this.sRW = paramViewGroup;
    this.sRX = paramView;
    this.context = paramContext;
    this.sSa = new ArrayList();
    this.ftH = paramString;
    this.sSd = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    ad.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.ftH });
    this.sRY = new f(this.context, this.sRX, this.ftH);
    this.sRY.sRO = this;
    this.sRZ = new h(this.context, this.sRW, this.ftH);
    Iterator localIterator = n.cJr().zz(this.ftH).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.sSa.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void Y(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    ad.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.sRY.Y(paramArrayList);
    h localh = this.sRZ;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.sSg.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.sSg.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.sSs)
    {
      localh.sSs = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.sSg.add(localObject1);
        }
      }
      localh.mI(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.sSg.add(paramArrayList);
      if (!bt.isNullOrNil(v.sh(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.mI(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!bt.isNullOrNil(paramArrayList)) && (localh.sSg.indexOf(paramArrayList) != -1))
      {
        localh.sSg.remove(localh.sSg.indexOf(paramArrayList));
        if (!bt.isNullOrNil(v.sh(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.mI(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void afb(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.sSe != null) {
      this.sSe.afb(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void afc(String paramString)
  {
    AppMethodBeat.i(55918);
    ad.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.sSc)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.sSb = paramString;
    paramString = this.sRY;
    Object localObject = this.sSb;
    ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      paramString.cJL();
      paramString = this.sRZ;
      localObject = this.sSb;
      ad.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bt.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!bt.isNullOrNil(v.sh((String)localObject)))
      {
        paramString.sSx = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.mI(true);
    }
    for (;;)
    {
      paramString = this.sSd.getViewByItag(this.sSb);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.cJL();
      paramString.aeY((String)localObject);
      break;
      label203:
      paramString.sSx = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.mI(true);
    }
  }
  
  public final void afd(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.sRZ;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(v.sh(paramString))))
    {
      localh.sSx = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void cJP()
  {
    AppMethodBeat.i(55917);
    ad.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.sSc = true;
    String str = u.aqG();
    this.sRY.cJL();
    this.sRY.aeY(str);
    Object localObject = this.sRZ;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.sSd.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.sSb = str;
    AppMethodBeat.o(55917);
  }
  
  public final void cJQ()
  {
    AppMethodBeat.i(55919);
    ad.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.sRY;
    Object localObject2 = u.aqG();
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).sRM.afa((String)localObject2))
    {
      ((f)localObject1).sRM.aeZ((String)localObject2).cJO();
      ((f)localObject1).sRM.notifyDataSetChanged();
      ((f)localObject1).sRL.invalidate();
    }
    localObject1 = this.sRZ;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.sSb = "";
    this.sSc = false;
    AppMethodBeat.o(55919);
  }
  
  public final void cJR()
  {
    AppMethodBeat.i(55920);
    h localh = this.sRZ;
    ad.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void afb(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */