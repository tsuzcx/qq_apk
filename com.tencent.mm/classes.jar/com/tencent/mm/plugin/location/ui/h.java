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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  TextView Vw;
  Context context;
  private String fyN;
  ArrayList<String> gIi;
  ao mHandler;
  private final int uaA;
  private final int uaB;
  private final int uaC;
  private final int uaD;
  boolean uaE;
  private int uaF;
  int uaG;
  int uaH;
  int uaI;
  boolean uaJ;
  String uaK;
  boolean uap;
  private ViewGroup uas;
  private final int uat;
  private final int uau;
  private final int uav;
  private final int uaw;
  private final int uax;
  private final int uay;
  private final int uaz;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.uat = 100;
    this.uau = 1;
    this.uav = 2;
    this.uaw = 3;
    this.uax = 4;
    this.uay = 5;
    this.uaz = 6;
    this.uaA = 7;
    this.uaB = 8;
    this.uaC = 9;
    this.uaD = 10;
    this.uaE = true;
    this.uaF = Color.parseColor("#44FEBB");
    this.uaG = Color.parseColor("#FFFFFF");
    this.uaH = Color.parseColor("#E54646");
    this.uaI = Color.parseColor("#FFC90C");
    this.uap = false;
    this.uaJ = false;
    this.uaK = "";
    this.mHandler = new ao(Looper.getMainLooper())
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
          h.this.Vw.setText(h.this.uaK);
          AppMethodBeat.o(55922);
          return;
          ac.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.uap), Boolean.valueOf(h.this.uaJ) });
          if ((!h.this.uap) && (!h.this.uaJ))
          {
            Object localObject = h.this;
            ((h)localObject).Vw.setTextColor(((h)localObject).uaG);
            ((h)localObject).Vw.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.Vw.setText(h.this.context.getString(2131764524));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.Vw.setText(h.this.context.getResources().getQuantityString(2131623971, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.uaJ) || (h.this.uap))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.uaK = h.this.Vw.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = v.wk((String)paramAnonymousMessage.obj);
            h.this.Vw.setText(h.this.context.getString(2131764530, new Object[] { paramAnonymousMessage }));
            if ((h.this.uap) || (h.this.uaJ))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.uaJ) || (h.this.uap))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.uaK = h.this.Vw.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = v.wk((String)paramAnonymousMessage.obj);
              h.this.Vw.setText(h.this.context.getString(2131764531, new Object[] { paramAnonymousMessage }));
              if ((h.this.uap) || (h.this.uaJ))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.uaJ = true;
                h.this.uap = false;
                h.a(h.this);
                paramAnonymousMessage = v.wk((String)paramAnonymousMessage.obj);
                h.this.Vw.setText(h.this.context.getString(2131764532, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.uap = true;
                h.this.uaJ = false;
                h.a(h.this);
                h.this.Vw.setText(h.this.context.getString(2131764529));
                AppMethodBeat.o(55922);
                return;
                h.this.uap = false;
                if (!h.this.uaJ)
                {
                  h.this.nA(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.uaJ = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Vw.setTextColor(paramAnonymousMessage.uaH);
                  paramAnonymousMessage.Vw.invalidate();
                  h.this.Vw.setText(h.this.context.getString(2131764534));
                  h.this.uaK = h.this.Vw.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Vw.setTextColor(paramAnonymousMessage.uaI);
                  paramAnonymousMessage.Vw.invalidate();
                  h.this.Vw.setText(h.this.context.getString(2131764535));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.uaJ = false;
                  h.this.nA(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.uas = paramViewGroup;
    this.Vw = ((TextView)this.uas.findViewById(2131305902));
    this.fyN = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    ac.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.Vw.invalidate();
    this.gIi = new ArrayList();
    Iterator localIterator = n.cWW().DE(this.fyN).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.gIi.add(str);
    }
    nA(false);
    AppMethodBeat.o(55924);
  }
  
  final void nA(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.gIi.size());
    ac.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.gIi.size()), Boolean.valueOf(paramBoolean) });
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