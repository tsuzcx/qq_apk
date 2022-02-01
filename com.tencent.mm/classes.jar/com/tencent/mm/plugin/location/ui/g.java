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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  implements f.c, i.a
{
  private Context context;
  private String fxo;
  private ViewGroup uaj;
  private View uak;
  private f ual;
  private h uam;
  private ArrayList<String> uan;
  private String uao;
  private boolean uap;
  private d uaq;
  public a uar;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.uao = "";
    this.fxo = "";
    this.uap = false;
    this.uaj = paramViewGroup;
    this.uak = paramView;
    this.context = paramContext;
    this.uan = new ArrayList();
    this.fxo = paramString;
    this.uaq = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    ac.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.fxo });
    this.ual = new f(this.context, this.uak, this.fxo);
    this.ual.uab = this;
    this.uam = new h(this.context, this.uaj, this.fxo);
    Iterator localIterator = n.cWW().DE(this.fxo).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.uan.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void aj(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    ac.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.ual.aj(paramArrayList);
    h localh = this.uam;
    ac.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.gIi.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.gIi.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.uaE)
    {
      localh.uaE = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.gIi.add(localObject1);
        }
      }
      localh.nA(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.gIi.add(paramArrayList);
      if (!bs.isNullOrNil(v.wk(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.nA(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!bs.isNullOrNil(paramArrayList)) && (localh.gIi.indexOf(paramArrayList) != -1))
      {
        localh.gIi.remove(localh.gIi.indexOf(paramArrayList));
        if (!bs.isNullOrNil(v.wk(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.nA(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void ajV(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.uar != null) {
      this.uar.ajV(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void ajW(String paramString)
  {
    AppMethodBeat.i(55918);
    ac.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.uap)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.uao = paramString;
    paramString = this.ual;
    Object localObject = this.uao;
    ac.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bs.isNullOrNil((String)localObject))
    {
      paramString.cXq();
      paramString = this.uam;
      localObject = this.uao;
      ac.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bs.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!bs.isNullOrNil(v.wk((String)localObject)))
      {
        paramString.uaJ = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.nA(true);
    }
    for (;;)
    {
      paramString = this.uaq.getViewByItag(this.uao);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.cXq();
      paramString.ajS((String)localObject);
      break;
      label203:
      paramString.uaJ = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.nA(true);
    }
  }
  
  public final void ajX(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.uam;
    ac.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(v.wk(paramString))))
    {
      localh.uaJ = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void cXu()
  {
    AppMethodBeat.i(55917);
    ac.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.uap = true;
    String str = u.axw();
    this.ual.cXq();
    this.ual.ajS(str);
    Object localObject = this.uam;
    ac.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.uaq.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.uao = str;
    AppMethodBeat.o(55917);
  }
  
  public final void cXv()
  {
    AppMethodBeat.i(55919);
    ac.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.ual;
    Object localObject2 = u.axw();
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).tZZ.ajU((String)localObject2))
    {
      ((f)localObject1).tZZ.ajT((String)localObject2).cXt();
      ((f)localObject1).tZZ.notifyDataSetChanged();
      ((f)localObject1).tZY.invalidate();
    }
    localObject1 = this.uam;
    ac.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.uao = "";
    this.uap = false;
    AppMethodBeat.o(55919);
  }
  
  public final void cXw()
  {
    AppMethodBeat.i(55920);
    h localh = this.uam;
    ac.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void ajV(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */