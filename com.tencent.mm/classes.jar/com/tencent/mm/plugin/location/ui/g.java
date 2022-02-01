package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.q.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  implements f.c, i.a
{
  private ViewGroup EmM;
  private View EmN;
  private f EmO;
  private h EmP;
  private ArrayList<String> EmQ;
  private String EmR;
  private boolean EmS;
  private d EmT;
  public a EmU;
  private Context context;
  private String jhR;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.EmR = "";
    this.jhR = "";
    this.EmS = false;
    this.EmM = paramViewGroup;
    this.EmN = paramView;
    this.context = paramContext;
    this.EmQ = new ArrayList();
    this.jhR = paramString;
    this.EmT = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    Log.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.jhR });
    this.EmO = new f(this.context, this.EmN, this.jhR);
    this.EmO.EmE = this;
    this.EmP = new h(this.context, this.EmM, this.jhR);
    Iterator localIterator = n.eMk().Xv(this.jhR).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.EmQ.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void aD(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    Log.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.EmO.aD(paramArrayList);
    h localh = this.EmP;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.kLY.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.kLY.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.Enh)
    {
      localh.Enh = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.kLY.add(localObject1);
        }
      }
      localh.tJ(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.kLY.add(paramArrayList);
      if (!Util.isNullOrNil(aa.PJ(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.tJ(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!Util.isNullOrNil(paramArrayList)) && (localh.kLY.indexOf(paramArrayList) != -1))
      {
        localh.kLY.remove(localh.kLY.indexOf(paramArrayList));
        if (!Util.isNullOrNil(aa.PJ(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.tJ(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void aNq(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.EmU != null) {
      this.EmU.aNq(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void aNr(String paramString)
  {
    AppMethodBeat.i(55918);
    Log.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.EmS)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.EmR = paramString;
    paramString = this.EmO;
    Object localObject = this.EmR;
    Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramString.eMF();
      paramString = this.EmP;
      localObject = this.EmR;
      Log.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!Util.isNullOrNil(aa.PJ((String)localObject)))
      {
        paramString.Enm = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.tJ(true);
    }
    for (;;)
    {
      paramString = this.EmT.getViewByItag(this.EmR);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.eMF();
      paramString.aNn((String)localObject);
      break;
      label203:
      paramString.Enm = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.tJ(true);
    }
  }
  
  public final void aNs(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.EmP;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(aa.PJ(paramString))))
    {
      localh.Enm = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void eMJ()
  {
    AppMethodBeat.i(55917);
    Log.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.EmS = true;
    String str = z.bcZ();
    this.EmO.eMF();
    this.EmO.aNn(str);
    Object localObject = this.EmP;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.EmT.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.EmR = str;
    AppMethodBeat.o(55917);
  }
  
  public final void eMK()
  {
    AppMethodBeat.i(55919);
    Log.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.EmO;
    Object localObject2 = z.bcZ();
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).EmC.aNp((String)localObject2))
    {
      ((f)localObject1).EmC.aNo((String)localObject2).eMI();
      ((f)localObject1).EmC.notifyDataSetChanged();
      ((f)localObject1).EmB.invalidate();
    }
    localObject1 = this.EmP;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.EmR = "";
    this.EmS = false;
    AppMethodBeat.o(55919);
  }
  
  public final void eML()
  {
    AppMethodBeat.i(55920);
    h localh = this.EmP;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void aNq(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */