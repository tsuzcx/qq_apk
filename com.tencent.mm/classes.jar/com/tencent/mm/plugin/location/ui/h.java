package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  TextView Xl;
  Context context;
  private String fUg;
  ArrayList<String> heG;
  aq mHandler;
  int vpA;
  int vpB;
  int vpC;
  boolean vpD;
  String vpE;
  boolean vpj;
  private ViewGroup vpm;
  private final int vpn;
  private final int vpo;
  private final int vpp;
  private final int vpq;
  private final int vpr;
  private final int vps;
  private final int vpt;
  private final int vpu;
  private final int vpv;
  private final int vpw;
  private final int vpx;
  boolean vpy;
  private int vpz;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.vpn = 100;
    this.vpo = 1;
    this.vpp = 2;
    this.vpq = 3;
    this.vpr = 4;
    this.vps = 5;
    this.vpt = 6;
    this.vpu = 7;
    this.vpv = 8;
    this.vpw = 9;
    this.vpx = 10;
    this.vpy = true;
    this.vpz = Color.parseColor("#44FEBB");
    this.vpA = Color.parseColor("#FFFFFF");
    this.vpB = Color.parseColor("#E54646");
    this.vpC = Color.parseColor("#FFC90C");
    this.vpj = false;
    this.vpD = false;
    this.vpE = "";
    this.mHandler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(55922);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(55922);
          return;
          h.this.Xl.setText(h.this.vpE);
          AppMethodBeat.o(55922);
          return;
          ae.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.vpj), Boolean.valueOf(h.this.vpD) });
          if ((!h.this.vpj) && (!h.this.vpD))
          {
            Object localObject = h.this;
            ((h)localObject).Xl.setTextColor(((h)localObject).vpA);
            ((h)localObject).Xl.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.Xl.setText(h.this.context.getString(2131764524));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.Xl.setText(h.this.context.getResources().getQuantityString(2131623971, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.vpD) || (h.this.vpj))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.vpE = h.this.Xl.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = w.zP((String)paramAnonymousMessage.obj);
            h.this.Xl.setText(h.this.context.getString(2131764530, new Object[] { paramAnonymousMessage }));
            if ((h.this.vpj) || (h.this.vpD))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.vpD) || (h.this.vpj))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.vpE = h.this.Xl.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = w.zP((String)paramAnonymousMessage.obj);
              h.this.Xl.setText(h.this.context.getString(2131764531, new Object[] { paramAnonymousMessage }));
              if ((h.this.vpj) || (h.this.vpD))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.vpD = true;
                h.this.vpj = false;
                h.a(h.this);
                paramAnonymousMessage = w.zP((String)paramAnonymousMessage.obj);
                h.this.Xl.setText(h.this.context.getString(2131764532, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.vpj = true;
                h.this.vpD = false;
                h.a(h.this);
                h.this.Xl.setText(h.this.context.getString(2131764529));
                AppMethodBeat.o(55922);
                return;
                h.this.vpj = false;
                if (!h.this.vpD)
                {
                  h.this.nZ(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.vpD = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xl.setTextColor(paramAnonymousMessage.vpB);
                  paramAnonymousMessage.Xl.invalidate();
                  h.this.Xl.setText(h.this.context.getString(2131764534));
                  h.this.vpE = h.this.Xl.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xl.setTextColor(paramAnonymousMessage.vpC);
                  paramAnonymousMessage.Xl.invalidate();
                  h.this.Xl.setText(h.this.context.getString(2131764535));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.vpD = false;
                  h.this.nZ(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.vpm = paramViewGroup;
    this.Xl = ((TextView)this.vpm.findViewById(2131305902));
    this.fUg = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    ae.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.Xl.invalidate();
    this.heG = new ArrayList();
    Iterator localIterator = n.djh().Hl(this.fUg).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.heG.add(str);
    }
    nZ(false);
    AppMethodBeat.o(55924);
  }
  
  final void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.heG.size());
    ae.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.heG.size()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.mHandler.sendMessageDelayed(localMessage, 100L);
      AppMethodBeat.o(55925);
      return;
    }
    this.mHandler.sendMessage(localMessage);
    AppMethodBeat.o(55925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */