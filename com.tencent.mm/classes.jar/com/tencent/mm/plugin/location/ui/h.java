package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.g;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  boolean EmS;
  private ViewGroup EmV;
  private final int EmW;
  private final int EmX;
  private final int EmY;
  private final int EmZ;
  private final int Ena;
  private final int Enb;
  private final int Enc;
  private final int End;
  private final int Ene;
  private final int Enf;
  private final int Eng;
  boolean Enh;
  private int Eni;
  int Enj;
  int Enk;
  int Enl;
  boolean Enm;
  String Enn;
  Context context;
  TextView eM;
  private String jjq;
  ArrayList<String> kLY;
  MMHandler mHandler;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.EmW = 100;
    this.EmX = 1;
    this.EmY = 2;
    this.EmZ = 3;
    this.Ena = 4;
    this.Enb = 5;
    this.Enc = 6;
    this.End = 7;
    this.Ene = 8;
    this.Enf = 9;
    this.Eng = 10;
    this.Enh = true;
    this.Eni = Color.parseColor("#44FEBB");
    this.Enj = Color.parseColor("#FFFFFF");
    this.Enk = Color.parseColor("#E54646");
    this.Enl = Color.parseColor("#FFC90C");
    this.EmS = false;
    this.Enm = false;
    this.Enn = "";
    this.mHandler = new MMHandler(Looper.getMainLooper())
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
          h.this.eM.setText(h.this.Enn);
          AppMethodBeat.o(55922);
          return;
          Log.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.EmS), Boolean.valueOf(h.this.Enm) });
          if ((!h.this.EmS) && (!h.this.Enm))
          {
            Object localObject = h.this;
            ((h)localObject).eM.setTextColor(((h)localObject).Enj);
            ((h)localObject).eM.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.eM.setText(h.this.context.getString(a.i.track_none_contact_num));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.eM.setText(h.this.context.getResources().getQuantityString(a.g.track_contact_num, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.Enm) || (h.this.EmS))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.Enn = h.this.eM.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = aa.PJ((String)paramAnonymousMessage.obj);
            h.this.eM.setText(h.this.context.getString(a.i.track_somebody_enter, new Object[] { paramAnonymousMessage }));
            if ((h.this.EmS) || (h.this.Enm))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.Enm) || (h.this.EmS))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.Enn = h.this.eM.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = aa.PJ((String)paramAnonymousMessage.obj);
              h.this.eM.setText(h.this.context.getString(a.i.track_somebody_exit, new Object[] { paramAnonymousMessage }));
              if ((h.this.EmS) || (h.this.Enm))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.Enm = true;
                h.this.EmS = false;
                h.a(h.this);
                paramAnonymousMessage = aa.PJ((String)paramAnonymousMessage.obj);
                h.this.eM.setText(h.this.context.getString(a.i.track_somebody_saying, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.EmS = true;
                h.this.Enm = false;
                h.a(h.this);
                h.this.eM.setText(h.this.context.getString(a.i.track_self_saying));
                AppMethodBeat.o(55922);
                return;
                h.this.EmS = false;
                if (!h.this.Enm)
                {
                  h.this.tJ(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.Enm = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.eM.setTextColor(paramAnonymousMessage.Enk);
                  paramAnonymousMessage.eM.invalidate();
                  h.this.eM.setText(h.this.context.getString(a.i.track_talk_conflict));
                  h.this.Enn = h.this.eM.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.eM.setTextColor(paramAnonymousMessage.Enl);
                  paramAnonymousMessage.eM.invalidate();
                  h.this.eM.setText(h.this.context.getString(a.i.track_talk_preparing));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.Enm = false;
                  h.this.tJ(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.EmV = paramViewGroup;
    this.eM = ((TextView)this.EmV.findViewById(a.e.title));
    this.jjq = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    Log.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.eM.invalidate();
    this.kLY = new ArrayList();
    Iterator localIterator = n.eMk().Xv(this.jjq).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.kLY.add(str);
    }
    tJ(false);
    AppMethodBeat.o(55924);
  }
  
  final void tJ(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.kLY.size());
    Log.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.kLY.size()), Boolean.valueOf(paramBoolean) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */