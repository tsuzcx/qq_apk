package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  TextView Xl;
  Context context;
  private String fSa;
  ArrayList<String> hbS;
  ap mHandler;
  boolean vcY;
  private ViewGroup vdb;
  private final int vdc;
  private final int vdd;
  private final int vde;
  private final int vdf;
  private final int vdg;
  private final int vdh;
  private final int vdi;
  private final int vdj;
  private final int vdk;
  private final int vdl;
  private final int vdm;
  boolean vdn;
  private int vdo;
  int vdp;
  int vdq;
  int vdr;
  boolean vds;
  String vdt;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.vdc = 100;
    this.vdd = 1;
    this.vde = 2;
    this.vdf = 3;
    this.vdg = 4;
    this.vdh = 5;
    this.vdi = 6;
    this.vdj = 7;
    this.vdk = 8;
    this.vdl = 9;
    this.vdm = 10;
    this.vdn = true;
    this.vdo = Color.parseColor("#44FEBB");
    this.vdp = Color.parseColor("#FFFFFF");
    this.vdq = Color.parseColor("#E54646");
    this.vdr = Color.parseColor("#FFC90C");
    this.vcY = false;
    this.vds = false;
    this.vdt = "";
    this.mHandler = new ap(Looper.getMainLooper())
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
          h.this.Xl.setText(h.this.vdt);
          AppMethodBeat.o(55922);
          return;
          ad.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.vcY), Boolean.valueOf(h.this.vds) });
          if ((!h.this.vcY) && (!h.this.vds))
          {
            Object localObject = h.this;
            ((h)localObject).Xl.setTextColor(((h)localObject).vdp);
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
            if ((h.this.vds) || (h.this.vcY))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.vdt = h.this.Xl.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = v.zf((String)paramAnonymousMessage.obj);
            h.this.Xl.setText(h.this.context.getString(2131764530, new Object[] { paramAnonymousMessage }));
            if ((h.this.vcY) || (h.this.vds))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.vds) || (h.this.vcY))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.vdt = h.this.Xl.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = v.zf((String)paramAnonymousMessage.obj);
              h.this.Xl.setText(h.this.context.getString(2131764531, new Object[] { paramAnonymousMessage }));
              if ((h.this.vcY) || (h.this.vds))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.vds = true;
                h.this.vcY = false;
                h.a(h.this);
                paramAnonymousMessage = v.zf((String)paramAnonymousMessage.obj);
                h.this.Xl.setText(h.this.context.getString(2131764532, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.vcY = true;
                h.this.vds = false;
                h.a(h.this);
                h.this.Xl.setText(h.this.context.getString(2131764529));
                AppMethodBeat.o(55922);
                return;
                h.this.vcY = false;
                if (!h.this.vds)
                {
                  h.this.nU(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.vds = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xl.setTextColor(paramAnonymousMessage.vdq);
                  paramAnonymousMessage.Xl.invalidate();
                  h.this.Xl.setText(h.this.context.getString(2131764534));
                  h.this.vdt = h.this.Xl.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xl.setTextColor(paramAnonymousMessage.vdr);
                  paramAnonymousMessage.Xl.invalidate();
                  h.this.Xl.setText(h.this.context.getString(2131764535));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.vds = false;
                  h.this.nU(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.vdb = paramViewGroup;
    this.Xl = ((TextView)this.vdb.findViewById(2131305902));
    this.fSa = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    ad.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.Xl.invalidate();
    this.hbS = new ArrayList();
    Iterator localIterator = n.dgi().GJ(this.fSa).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.hbS.add(str);
    }
    nU(false);
    AppMethodBeat.o(55924);
  }
  
  final void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.hbS.size());
    ad.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.hbS.size()), Boolean.valueOf(paramBoolean) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */