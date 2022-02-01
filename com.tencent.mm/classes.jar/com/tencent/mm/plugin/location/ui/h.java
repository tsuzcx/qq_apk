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
  TextView UA;
  Context context;
  private String fvg;
  ap mHandler;
  boolean sSc;
  private ViewGroup sSf;
  ArrayList<String> sSg;
  private final int sSh;
  private final int sSi;
  private final int sSj;
  private final int sSk;
  private final int sSl;
  private final int sSm;
  private final int sSn;
  private final int sSo;
  private final int sSp;
  private final int sSq;
  private final int sSr;
  boolean sSs;
  private int sSt;
  int sSu;
  int sSv;
  int sSw;
  boolean sSx;
  String sSy;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.sSh = 100;
    this.sSi = 1;
    this.sSj = 2;
    this.sSk = 3;
    this.sSl = 4;
    this.sSm = 5;
    this.sSn = 6;
    this.sSo = 7;
    this.sSp = 8;
    this.sSq = 9;
    this.sSr = 10;
    this.sSs = true;
    this.sSt = Color.parseColor("#44FEBB");
    this.sSu = Color.parseColor("#FFFFFF");
    this.sSv = Color.parseColor("#E54646");
    this.sSw = Color.parseColor("#FFC90C");
    this.sSc = false;
    this.sSx = false;
    this.sSy = "";
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
          h.this.UA.setText(h.this.sSy);
          AppMethodBeat.o(55922);
          return;
          ad.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.sSc), Boolean.valueOf(h.this.sSx) });
          if ((!h.this.sSc) && (!h.this.sSx))
          {
            Object localObject = h.this;
            ((h)localObject).UA.setTextColor(((h)localObject).sSu);
            ((h)localObject).UA.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.UA.setText(h.this.context.getString(2131764524));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.UA.setText(h.this.context.getResources().getQuantityString(2131623971, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.sSx) || (h.this.sSc))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.sSy = h.this.UA.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = v.sh((String)paramAnonymousMessage.obj);
            h.this.UA.setText(h.this.context.getString(2131764530, new Object[] { paramAnonymousMessage }));
            if ((h.this.sSc) || (h.this.sSx))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.sSx) || (h.this.sSc))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.sSy = h.this.UA.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = v.sh((String)paramAnonymousMessage.obj);
              h.this.UA.setText(h.this.context.getString(2131764531, new Object[] { paramAnonymousMessage }));
              if ((h.this.sSc) || (h.this.sSx))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.sSx = true;
                h.this.sSc = false;
                h.a(h.this);
                paramAnonymousMessage = v.sh((String)paramAnonymousMessage.obj);
                h.this.UA.setText(h.this.context.getString(2131764532, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.sSc = true;
                h.this.sSx = false;
                h.a(h.this);
                h.this.UA.setText(h.this.context.getString(2131764529));
                AppMethodBeat.o(55922);
                return;
                h.this.sSc = false;
                if (!h.this.sSx)
                {
                  h.this.mI(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.sSx = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.UA.setTextColor(paramAnonymousMessage.sSv);
                  paramAnonymousMessage.UA.invalidate();
                  h.this.UA.setText(h.this.context.getString(2131764534));
                  h.this.sSy = h.this.UA.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.UA.setTextColor(paramAnonymousMessage.sSw);
                  paramAnonymousMessage.UA.invalidate();
                  h.this.UA.setText(h.this.context.getString(2131764535));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.sSx = false;
                  h.this.mI(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.sSf = paramViewGroup;
    this.UA = ((TextView)this.sSf.findViewById(2131305902));
    this.fvg = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    ad.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.UA.invalidate();
    this.sSg = new ArrayList();
    Iterator localIterator = n.cJr().zz(this.fvg).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.sSg.add(str);
    }
    mI(false);
    AppMethodBeat.o(55924);
  }
  
  final void mI(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.sSg.size());
    ad.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.sSg.size()), Boolean.valueOf(paramBoolean) });
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