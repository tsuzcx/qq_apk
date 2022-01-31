package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  implements h.c, k.a
{
  private Context context;
  private String dpx = "";
  private ViewGroup lFX;
  private View lFY;
  private h lFZ;
  private d lFy;
  private j lGa;
  private ArrayList<String> lGb;
  private String lGc = "";
  private boolean lGd = false;
  public i.a lGe;
  
  public i(Context paramContext, ViewGroup paramViewGroup, View paramView, String paramString, d paramd)
  {
    this.lFX = paramViewGroup;
    this.lFY = paramView;
    this.context = paramContext;
    this.lGb = new ArrayList();
    this.dpx = paramString;
    this.lFy = paramd;
    init();
  }
  
  private void init()
  {
    y.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[] { this.dpx });
    this.lFZ = new h(this.context, this.lFY, this.dpx);
    this.lFZ.lFP = this;
    this.lGa = new j(this.context, this.lFX, this.dpx);
    Iterator localIterator = l.bdY().nz(this.dpx).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.lGb.add(str);
    }
  }
  
  public final void G(ArrayList<String> paramArrayList)
  {
    y.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.lFZ.G(paramArrayList);
    j localj = this.lGa;
    y.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (localj.lGg.indexOf(str) == -1) {
        ((ArrayList)localObject2).add(str);
      }
    }
    localIterator = localj.lGg.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (paramArrayList.indexOf(str) == -1) {
        ((ArrayList)localObject1).add(str);
      }
    }
    if (localj.lGs)
    {
      localj.lGs = false;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramArrayList = ((ArrayList)localObject2).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (String)paramArrayList.next();
          localj.lGg.add(localObject1);
        }
      }
      localj.hi(false);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (((ArrayList)localObject2).size() > 0)
          {
            paramArrayList = (String)((ArrayList)localObject2).get(0);
            localj.lGg.add(paramArrayList);
            if (!bk.bl(r.gV(paramArrayList)))
            {
              localj.mHandler.removeMessages(3);
              localObject2 = Message.obtain();
              ((Message)localObject2).what = 3;
              ((Message)localObject2).obj = paramArrayList;
              localj.mHandler.sendMessage((Message)localObject2);
              localj.hi(true);
            }
          }
        } while (((ArrayList)localObject1).size() <= 0);
        paramArrayList = (String)((ArrayList)localObject1).get(0);
      } while ((bk.bl(paramArrayList)) || (localj.lGg.indexOf(paramArrayList) == -1));
      localj.lGg.remove(localj.lGg.indexOf(paramArrayList));
    } while (bk.bl(r.gV(paramArrayList)));
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 4;
    ((Message)localObject1).obj = paramArrayList;
    localj.mHandler.sendMessage((Message)localObject1);
    localj.hi(true);
  }
  
  public final void GE(String paramString)
  {
    if (this.lGe != null) {
      this.lGe.GE(paramString);
    }
  }
  
  public final void GF(String paramString)
  {
    y.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[] { paramString });
    if (this.lGd) {
      return;
    }
    this.lGc = paramString;
    paramString = this.lFZ;
    Object localObject = this.lGc;
    y.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[] { localObject });
    if (bk.bl((String)localObject))
    {
      paramString.beq();
      label64:
      paramString = this.lGa;
      localObject = this.lGc;
      y.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[] { localObject });
      if (bk.bl((String)localObject)) {
        break label188;
      }
      if (!bk.bl(r.gV((String)localObject)))
      {
        paramString.lGx = true;
        paramString.mHandler.removeMessages(5);
        Message localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = localObject;
        paramString.mHandler.sendMessageAtFrontOfQueue(localMessage);
      }
      paramString.hi(true);
    }
    for (;;)
    {
      paramString = this.lFy.getViewByItag(this.lGc);
      if (!(paramString instanceof TrackPoint)) {
        break;
      }
      ((TrackPoint)paramString).set2Top();
      return;
      paramString.beq();
      paramString.GB((String)localObject);
      break label64;
      label188:
      paramString.lGx = false;
      paramString.mHandler.removeMessages(10);
      localObject = Message.obtain();
      ((Message)localObject).what = 10;
      paramString.mHandler.sendMessage((Message)localObject);
      paramString.hi(true);
    }
  }
  
  public final void GG(String paramString)
  {
    j localj = this.lGa;
    y.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[] { paramString });
    if ((!bk.bl(paramString)) && (!bk.bl(r.gV(paramString))))
    {
      localj.lGx = true;
      localj.mHandler.removeMessages(7);
      paramString = Message.obtain();
      paramString.what = 7;
      localj.mHandler.sendMessageAtFrontOfQueue(paramString);
    }
  }
  
  public final void beu()
  {
    y.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
    this.lGd = true;
    String str = q.Gj();
    this.lFZ.beq();
    this.lFZ.GB(str);
    Object localObject = this.lGa;
    y.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
    ((j)localObject).mHandler.removeMessages(6);
    ((j)localObject).mHandler.removeMessages(5);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    ((j)localObject).mHandler.sendMessageAtFrontOfQueue(localMessage);
    localObject = this.lFy.getViewByItag(str);
    if ((localObject instanceof TrackPoint)) {
      ((TrackPoint)localObject).set2Top();
    }
    this.lGc = str;
  }
  
  public final void bev()
  {
    y.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
    Object localObject1 = this.lFZ;
    Object localObject2 = q.Gj();
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[] { localObject2 });
    if (((h)localObject1).lFN.GD((String)localObject2))
    {
      ((h)localObject1).lFN.GC((String)localObject2).bet();
      ((h)localObject1).lFN.notifyDataSetChanged();
      ((h)localObject1).lFM.invalidate();
    }
    localObject1 = this.lGa;
    y.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
    ((j)localObject1).mHandler.removeMessages(9);
    ((j)localObject1).mHandler.removeMessages(10);
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 9;
    ((j)localObject1).mHandler.sendMessage((Message)localObject2);
    this.lGc = "";
    this.lGd = false;
  }
  
  public final void bew()
  {
    j localj = this.lGa;
    y.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
    localj.mHandler.removeMessages(8);
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localj.mHandler.sendMessageAtFrontOfQueue(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */