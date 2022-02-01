package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
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
  private Context context;
  private String gxP;
  private ViewGroup yIT;
  private View yIU;
  private f yIV;
  private h yIW;
  private ArrayList<String> yIX;
  private String yIY;
  private boolean yIZ;
  private d yJa;
  public a yJb;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.yIY = "";
    this.gxP = "";
    this.yIZ = false;
    this.yIT = paramViewGroup;
    this.yIU = paramView;
    this.context = paramContext;
    this.yIX = new ArrayList();
    this.gxP = paramString;
    this.yJa = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    Log.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.gxP });
    this.yIV = new f(this.context, this.yIU, this.gxP);
    this.yIV.yIL = this;
    this.yIW = new h(this.context, this.yIT, this.gxP);
    Iterator localIterator = n.ecS().PY(this.gxP).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.yIX.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void aDg(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.yJb != null) {
      this.yJb.aDg(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void aDh(String paramString)
  {
    AppMethodBeat.i(55918);
    Log.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.yIZ)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.yIY = paramString;
    paramString = this.yIV;
    Object localObject = this.yIY;
    Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramString.edm();
      paramString = this.yIW;
      localObject = this.yIY;
      Log.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!Util.isNullOrNil(aa.getDisplayName((String)localObject)))
      {
        paramString.yJt = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.qH(true);
    }
    for (;;)
    {
      paramString = this.yJa.getViewByItag(this.yIY);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.edm();
      paramString.aDd((String)localObject);
      break;
      label203:
      paramString.yJt = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.qH(true);
    }
  }
  
  public final void aDi(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.yIW;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(aa.getDisplayName(paramString))))
    {
      localh.yJt = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void aw(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    Log.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.yIV.aw(paramArrayList);
    h localh = this.yIW;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.hXt.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.hXt.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.yJo)
    {
      localh.yJo = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.hXt.add(localObject1);
        }
      }
      localh.qH(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.hXt.add(paramArrayList);
      if (!Util.isNullOrNil(aa.getDisplayName(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.qH(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!Util.isNullOrNil(paramArrayList)) && (localh.hXt.indexOf(paramArrayList) != -1))
      {
        localh.hXt.remove(localh.hXt.indexOf(paramArrayList));
        if (!Util.isNullOrNil(aa.getDisplayName(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.qH(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void edq()
  {
    AppMethodBeat.i(55917);
    Log.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.yIZ = true;
    String str = z.aTY();
    this.yIV.edm();
    this.yIV.aDd(str);
    Object localObject = this.yIW;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.yJa.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.yIY = str;
    AppMethodBeat.o(55917);
  }
  
  public final void edr()
  {
    AppMethodBeat.i(55919);
    Log.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.yIV;
    Object localObject2 = z.aTY();
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).yIJ.aDf((String)localObject2))
    {
      ((f)localObject1).yIJ.aDe((String)localObject2).edp();
      ((f)localObject1).yIJ.notifyDataSetChanged();
      ((f)localObject1).yII.invalidate();
    }
    localObject1 = this.yIW;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.yIY = "";
    this.yIZ = false;
    AppMethodBeat.o(55919);
  }
  
  public final void eds()
  {
    AppMethodBeat.i(55920);
    h localh = this.yIW;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void aDg(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */