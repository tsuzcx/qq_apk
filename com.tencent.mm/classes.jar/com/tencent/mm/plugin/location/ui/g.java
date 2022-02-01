package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.p.d;
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
  private boolean KfA;
  private d KfB;
  public a KfC;
  private ViewGroup Kfv;
  private View Kfw;
  private f Kfx;
  private h Kfy;
  private String Kfz;
  private Context context;
  private ArrayList<String> lKN;
  private String lKh;
  
  public g(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    AppMethodBeat.i(55913);
    this.Kfz = "";
    this.lKh = "";
    this.KfA = false;
    this.Kfv = paramViewGroup;
    this.Kfw = paramView;
    this.context = paramContext;
    this.lKN = new ArrayList();
    this.lKh = paramString;
    this.KfB = paramd;
    init();
    AppMethodBeat.o(55913);
  }
  
  private void init()
  {
    AppMethodBeat.i(55914);
    Log.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.lKh });
    this.Kfx = new f(this.context, this.Kfw, this.lKh);
    this.Kfx.Kfn = this;
    this.Kfy = new h(this.context, this.Kfv, this.lKh);
    Iterator localIterator = SubCoreLocation.fUC().Px(this.lKh).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.lKN.add(str);
    }
    AppMethodBeat.o(55914);
  }
  
  public final void aKl(String paramString)
  {
    AppMethodBeat.i(55916);
    if (this.KfC != null) {
      this.KfC.aKl(paramString);
    }
    AppMethodBeat.o(55916);
  }
  
  public final void aKm(String paramString)
  {
    AppMethodBeat.i(55918);
    Log.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.KfA)
    {
      AppMethodBeat.o(55918);
      return;
    }
    this.Kfz = paramString;
    paramString = this.Kfx;
    Object localObject = this.Kfz;
    Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramString.fUY();
      paramString = this.Kfy;
      localObject = this.Kfz;
      Log.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject)) {
        break label203;
      }
      if (!Util.isNullOrNil(aa.getDisplayName((String)localObject)))
      {
        paramString.KfU = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.xV(true);
    }
    for (;;)
    {
      paramString = this.KfB.getViewByItag(this.Kfz);
      if ((paramString instanceof TrackPoint)) {
        ((TrackPoint)paramString).set2Top();
      }
      AppMethodBeat.o(55918);
      return;
      paramString.fUY();
      paramString.aKi((String)localObject);
      break;
      label203:
      paramString.KfU = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.xV(true);
    }
  }
  
  public final void aKn(String paramString)
  {
    AppMethodBeat.i(55921);
    h localh = this.Kfy;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(aa.getDisplayName(paramString))))
    {
      localh.KfU = true;
      localh.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localh.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
    AppMethodBeat.o(55921);
  }
  
  public final void aW(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55915);
    Log.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.Kfx.aW(paramArrayList);
    h localh = this.Kfy;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localh.nnU.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localh.nnU.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localh.KfP)
    {
      localh.KfP = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localh.nnU.add(localObject1);
        }
      }
      localh.xV(false);
      AppMethodBeat.o(55915);
      return;
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject2).get(0);
      localh.nnU.add(paramArrayList);
      if (!Util.isNullOrNil(aa.getDisplayName(paramArrayList)))
      {
        localh.mHandler.removeMessages(3);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 3;
        ((Message)localObject2).obj = paramArrayList;
        localh.mHandler.sendMessage((Message)localObject2);
        localh.xV(true);
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = (String)((ArrayList)localObject1).get(0);
      if ((!Util.isNullOrNil(paramArrayList)) && (localh.nnU.indexOf(paramArrayList) != -1))
      {
        localh.nnU.remove(localh.nnU.indexOf(paramArrayList));
        if (!Util.isNullOrNil(aa.getDisplayName(paramArrayList)))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 4;
          ((Message)localObject1).obj = paramArrayList;
          localh.mHandler.sendMessage((Message)localObject1);
          localh.xV(true);
        }
      }
    }
    AppMethodBeat.o(55915);
  }
  
  public final void fVc()
  {
    AppMethodBeat.i(55917);
    Log.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.KfA = true;
    String str = z.bAM();
    this.Kfx.fUY();
    this.Kfx.aKi(str);
    Object localObject = this.Kfy;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((h)localObject).mHandler.removeMessages(6);
    ((h)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((h)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.KfB.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.Kfz = str;
    AppMethodBeat.o(55917);
  }
  
  public final void fVd()
  {
    AppMethodBeat.i(55919);
    Log.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.Kfx;
    Object localObject2 = z.bAM();
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((f)localObject1).Kfl.aKk((String)localObject2))
    {
      ((f)localObject1).Kfl.aKj((String)localObject2).fVb();
      ((f)localObject1).Kfl.notifyDataSetChanged();
      ((f)localObject1).Kfk.invalidate();
    }
    localObject1 = this.Kfy;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((h)localObject1).mHandler.removeMessages(9);
    ((h)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((h)localObject1).mHandler.sendMessage((Message)localObject2);
    this.Kfz = "";
    this.KfA = false;
    AppMethodBeat.o(55919);
  }
  
  public final void fVe()
  {
    AppMethodBeat.i(55920);
    h localh = this.Kfy;
    Log.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localh.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localh.mHandler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(55920);
  }
  
  public static abstract interface a
  {
    public abstract void aKl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */