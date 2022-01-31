package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  TextView Nx;
  Context context;
  private String eis;
  ak mHandler;
  private final int odA;
  private final int odB;
  private final int odC;
  private final int odD;
  private final int odE;
  boolean odF;
  private int odG;
  int odH;
  int odI;
  int odJ;
  boolean odK;
  String odL;
  boolean odq;
  private ViewGroup ods;
  ArrayList<String> odt;
  private final int odu;
  private final int odv;
  private final int odw;
  private final int odx;
  private final int ody;
  private final int odz;
  
  public j(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(113522);
    this.odu = 100;
    this.odv = 1;
    this.odw = 2;
    this.odx = 3;
    this.ody = 4;
    this.odz = 5;
    this.odA = 6;
    this.odB = 7;
    this.odC = 8;
    this.odD = 9;
    this.odE = 10;
    this.odF = true;
    this.odG = Color.parseColor("#44FEBB");
    this.odH = Color.parseColor("#FFFFFF");
    this.odI = Color.parseColor("#E54646");
    this.odJ = Color.parseColor("#FFC90C");
    this.odq = false;
    this.odK = false;
    this.odL = "";
    this.mHandler = new j.1(this, Looper.getMainLooper());
    this.context = paramContext;
    this.ods = paramViewGroup;
    this.Nx = ((TextView)this.ods.findViewById(2131820680));
    this.eis = paramString;
    init();
    AppMethodBeat.o(113522);
  }
  
  private void init()
  {
    AppMethodBeat.i(113523);
    ab.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.Nx.invalidate();
    this.odt = new ArrayList();
    Iterator localIterator = l.bLs().uN(this.eis).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.odt.add(str);
    }
    iS(false);
    AppMethodBeat.o(113523);
  }
  
  final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(113524);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.odt.size());
    ab.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.odt.size()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.mHandler.sendMessageDelayed(localMessage, 100L);
      AppMethodBeat.o(113524);
      return;
    }
    this.mHandler.sendMessage(localMessage);
    AppMethodBeat.o(113524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j
 * JD-Core Version:    0.7.0.1
 */