package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  implements f.c, i.a
{
  private Context context;
  private String fSH;
  private ViewGroup vpd;
  private View vpe;
  private f vpf;
  private h vpg;
  private ArrayList<String> vph;
  private String vpi;
  private boolean vpj;
  private d vpk;
  public a vpl;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.vpi = "";
    this.fSH = "";
    this.vpj = false;
    this.vpd = paramViewGroup;
    this.vpe = paramView;
    this.context = paramContext;
    this.vph = new ArrayList();
    this.fSH = paramString;
    this.vpk = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    ae.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.fSH });
    this.vpf = new f(this.context, this.vpe, this.fSH);
    this.vpf.voV = this;
    this.vpg = new h(this.context, this.vpd, this.fSH);
    Iterator localIterator = n.djh().Hl(this.fSH).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.vph.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    ae.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.vpf.ai(paramArrayList);
    h localh = this.vpg;
    ae.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.heG.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.heG.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.vpy)
    {
      localh.vpy = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.heG.add(localObject1);
        }
      }
      localh.nZ(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.heG.add(paramArrayList);
      if (!bu.isNullOrNil(w.zP(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.nZ(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!bu.isNullOrNil(paramArrayList)) && (localh.heG.indexOf(paramArrayList) != -1))
      {
        localh.heG.remove(localh.heG.indexOf(paramArrayList));
        if (!bu.isNullOrNil(w.zP(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.nZ(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void apN(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.vpl != null) {
      this.vpl.apN(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void apO(String paramString)
  {
    AppMethodBeat.i(55918);
    ae.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.vpj)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.vpi = paramString;
    paramString = this.vpf;
    Object localObject = this.vpi;
    ae.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      paramString.djB();
      paramString = this.vpg;
      localObject = this.vpi;
      ae.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bu.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!bu.isNullOrNil(w.zP((String)localObject)))
      {
        paramString.vpD = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.nZ(true);
    }
    for (;;)
    {
      paramString = this.vpk.getViewByItag(this.vpi);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.djB();
      paramString.apK((String)localObject);
      break;
      label203:
      paramString.vpD = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.nZ(true);
    }
  }
  
  public final void apP(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.vpg;
    ae.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(w.zP(paramString))))
    {
      localh.vpD = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void djF()
  {
    AppMethodBeat.i(55917);
    ae.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.vpj = true;
    String str = v.aAC();
    this.vpf.djB();
    this.vpf.apK(str);
    Object localObject = this.vpg;
    ae.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.vpk.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.vpi = str;
    AppMethodBeat.o(55917);
  }
  
  public final void djG()
  {
    AppMethodBeat.i(55919);
    ae.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.vpf;
    Object localObject2 = v.aAC();
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).voT.apM((String)localObject2))
    {
      ((f)localObject1).voT.apL((String)localObject2).djE();
      ((f)localObject1).voT.notifyDataSetChanged();
      ((f)localObject1).voS.invalidate();
    }
    localObject1 = this.vpg;
    ae.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.vpi = "";
    this.vpj = false;
    AppMethodBeat.o(55919);
  }
  
  public final void djH()
  {
    AppMethodBeat.i(55920);
    h localh = this.vpg;
    ae.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void apN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */