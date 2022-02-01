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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  TextView Xy;
  Context context;
  private String gzn;
  ArrayList<String> hXt;
  MMHandler mHandler;
  boolean yIZ;
  private ViewGroup yJc;
  private final int yJd;
  private final int yJe;
  private final int yJf;
  private final int yJg;
  private final int yJh;
  private final int yJi;
  private final int yJj;
  private final int yJk;
  private final int yJl;
  private final int yJm;
  private final int yJn;
  boolean yJo;
  private int yJp;
  int yJq;
  int yJr;
  int yJs;
  boolean yJt;
  String yJu;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.yJd = 100;
    this.yJe = 1;
    this.yJf = 2;
    this.yJg = 3;
    this.yJh = 4;
    this.yJi = 5;
    this.yJj = 6;
    this.yJk = 7;
    this.yJl = 8;
    this.yJm = 9;
    this.yJn = 10;
    this.yJo = true;
    this.yJp = Color.parseColor("#44FEBB");
    this.yJq = Color.parseColor("#FFFFFF");
    this.yJr = Color.parseColor("#E54646");
    this.yJs = Color.parseColor("#FFC90C");
    this.yIZ = false;
    this.yJt = false;
    this.yJu = "";
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
          h.this.Xy.setText(h.this.yJu);
          AppMethodBeat.o(55922);
          return;
          Log.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.yIZ), Boolean.valueOf(h.this.yJt) });
          if ((!h.this.yIZ) && (!h.this.yJt))
          {
            Object localObject = h.this;
            ((h)localObject).Xy.setTextColor(((h)localObject).yJq);
            ((h)localObject).Xy.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.Xy.setText(h.this.context.getString(2131766868));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.Xy.setText(h.this.context.getResources().getQuantityString(2131623971, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.yJt) || (h.this.yIZ))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.yJu = h.this.Xy.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
            h.this.Xy.setText(h.this.context.getString(2131766874, new Object[] { paramAnonymousMessage }));
            if ((h.this.yIZ) || (h.this.yJt))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.yJt) || (h.this.yIZ))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.yJu = h.this.Xy.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
              h.this.Xy.setText(h.this.context.getString(2131766875, new Object[] { paramAnonymousMessage }));
              if ((h.this.yIZ) || (h.this.yJt))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.yJt = true;
                h.this.yIZ = false;
                h.a(h.this);
                paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
                h.this.Xy.setText(h.this.context.getString(2131766876, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.yIZ = true;
                h.this.yJt = false;
                h.a(h.this);
                h.this.Xy.setText(h.this.context.getString(2131766873));
                AppMethodBeat.o(55922);
                return;
                h.this.yIZ = false;
                if (!h.this.yJt)
                {
                  h.this.qH(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.yJt = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xy.setTextColor(paramAnonymousMessage.yJr);
                  paramAnonymousMessage.Xy.invalidate();
                  h.this.Xy.setText(h.this.context.getString(2131766878));
                  h.this.yJu = h.this.Xy.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.Xy.setTextColor(paramAnonymousMessage.yJs);
                  paramAnonymousMessage.Xy.invalidate();
                  h.this.Xy.setText(h.this.context.getString(2131766879));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.yJt = false;
                  h.this.qH(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.yJc = paramViewGroup;
    this.Xy = ((TextView)this.yJc.findViewById(2131309195));
    this.gzn = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    Log.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.Xy.invalidate();
    this.hXt = new ArrayList();
    Iterator localIterator = n.ecS().PY(this.gzn).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.hXt.add(str);
    }
    qH(false);
    AppMethodBeat.o(55924);
  }
  
  final void qH(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.hXt.size());
    Log.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.hXt.size()), Boolean.valueOf(paramBoolean) });
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