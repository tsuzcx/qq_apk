package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  TextView NI;
  Context context;
  private String dqQ;
  boolean lGd = false;
  private ViewGroup lGf;
  ArrayList<String> lGg;
  private final int lGh = 100;
  private final int lGi = 1;
  private final int lGj = 2;
  private final int lGk = 3;
  private final int lGl = 4;
  private final int lGm = 5;
  private final int lGn = 6;
  private final int lGo = 7;
  private final int lGp = 8;
  private final int lGq = 9;
  private final int lGr = 10;
  boolean lGs = true;
  private int lGt = Color.parseColor("#44FEBB");
  int lGu = Color.parseColor("#FFFFFF");
  int lGv = Color.parseColor("#E54646");
  int lGw = Color.parseColor("#FFC90C");
  boolean lGx = false;
  String lGy = "";
  ah mHandler = new j.1(this, Looper.getMainLooper());
  
  public j(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    this.context = paramContext;
    this.lGf = paramViewGroup;
    this.NI = ((TextView)this.lGf.findViewById(a.e.title));
    this.dqQ = paramString;
    init();
  }
  
  private void init()
  {
    y.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.NI.invalidate();
    this.lGg = new ArrayList();
    Iterator localIterator = l.bdY().nz(this.dqQ).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.lGg.add(str);
    }
    hi(false);
  }
  
  final void hi(boolean paramBoolean)
  {
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.lGg.size());
    y.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.lGg.size()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.mHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    this.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */