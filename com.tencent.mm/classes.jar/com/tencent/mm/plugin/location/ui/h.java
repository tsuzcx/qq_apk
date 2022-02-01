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
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.p;
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
  boolean KfA;
  private ViewGroup KfD;
  private final int KfE;
  private final int KfF;
  private final int KfG;
  private final int KfH;
  private final int KfI;
  private final int KfJ;
  private final int KfK;
  private final int KfL;
  private final int KfM;
  private final int KfN;
  private final int KfO;
  boolean KfP;
  private int KfQ;
  int KfR;
  int KfS;
  int KfT;
  boolean KfU;
  String KfV;
  Context context;
  TextView fO;
  private String lLV;
  MMHandler mHandler;
  ArrayList<String> nnU;
  
  public h(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(55923);
    this.KfE = 100;
    this.KfF = 1;
    this.KfG = 2;
    this.KfH = 3;
    this.KfI = 4;
    this.KfJ = 5;
    this.KfK = 6;
    this.KfL = 7;
    this.KfM = 8;
    this.KfN = 9;
    this.KfO = 10;
    this.KfP = true;
    this.KfQ = Color.parseColor("#44FEBB");
    this.KfR = Color.parseColor("#FFFFFF");
    this.KfS = Color.parseColor("#E54646");
    this.KfT = Color.parseColor("#FFC90C");
    this.KfA = false;
    this.KfU = false;
    this.KfV = "";
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
          h.this.fO.setText(h.this.KfV);
          AppMethodBeat.o(55922);
          return;
          Log.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(h.this.KfA), Boolean.valueOf(h.this.KfU) });
          if ((!h.this.KfA) && (!h.this.KfU))
          {
            Object localObject = h.this;
            ((h)localObject).fO.setTextColor(((h)localObject).KfR);
            ((h)localObject).fO.invalidate();
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            if (i == 0)
            {
              h.this.fO.setText(h.this.context.getString(a.i.track_none_contact_num));
              AppMethodBeat.o(55922);
              return;
            }
            h.this.fO.setText(h.this.context.getResources().getQuantityString(a.g.track_contact_num, i, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(55922);
            return;
            if ((h.this.KfU) || (h.this.KfA))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramAnonymousMessage.obj;
              sendMessage((Message)localObject);
              AppMethodBeat.o(55922);
              return;
            }
            h.this.KfV = h.this.fO.getText().toString();
            h.a(h.this);
            paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
            h.this.fO.setText(h.this.context.getString(a.i.track_somebody_enter, new Object[] { paramAnonymousMessage }));
            if ((h.this.KfA) || (h.this.KfU))
            {
              h.b(h.this);
              AppMethodBeat.o(55922);
              return;
              if ((h.this.KfU) || (h.this.KfA))
              {
                removeMessages(4);
                localObject = Message.obtain();
                ((Message)localObject).what = 4;
                ((Message)localObject).obj = paramAnonymousMessage.obj;
                sendMessage((Message)localObject);
                AppMethodBeat.o(55922);
                return;
              }
              h.this.KfV = h.this.fO.getText().toString();
              h.a(h.this);
              paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
              h.this.fO.setText(h.this.context.getString(a.i.track_somebody_exit, new Object[] { paramAnonymousMessage }));
              if ((h.this.KfA) || (h.this.KfU))
              {
                h.b(h.this);
                AppMethodBeat.o(55922);
                return;
                h.this.KfU = true;
                h.this.KfA = false;
                h.a(h.this);
                paramAnonymousMessage = aa.getDisplayName((String)paramAnonymousMessage.obj);
                h.this.fO.setText(h.this.context.getString(a.i.track_somebody_saying, new Object[] { paramAnonymousMessage }));
                AppMethodBeat.o(55922);
                return;
                h.this.KfA = true;
                h.this.KfU = false;
                h.a(h.this);
                h.this.fO.setText(h.this.context.getString(a.i.track_self_saying));
                AppMethodBeat.o(55922);
                return;
                h.this.KfA = false;
                if (!h.this.KfU)
                {
                  h.this.xV(true);
                  AppMethodBeat.o(55922);
                  return;
                  h.this.KfU = true;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.fO.setTextColor(paramAnonymousMessage.KfS);
                  paramAnonymousMessage.fO.invalidate();
                  h.this.fO.setText(h.this.context.getString(a.i.track_talk_conflict));
                  h.this.KfV = h.this.fO.getText().toString();
                  h.b(h.this);
                  AppMethodBeat.o(55922);
                  return;
                  paramAnonymousMessage = h.this;
                  paramAnonymousMessage.fO.setTextColor(paramAnonymousMessage.KfT);
                  paramAnonymousMessage.fO.invalidate();
                  h.this.fO.setText(h.this.context.getString(a.i.track_talk_preparing));
                  AppMethodBeat.o(55922);
                  return;
                  h.this.KfU = false;
                  h.this.xV(false);
                }
              }
            }
          }
        }
      }
    };
    this.context = paramContext;
    this.KfD = paramViewGroup;
    this.fO = ((TextView)this.KfD.findViewById(a.e.title));
    this.lLV = paramString;
    init();
    AppMethodBeat.o(55923);
  }
  
  private void init()
  {
    AppMethodBeat.i(55924);
    Log.d("MicroMsg.ShareHeaderMsgMgr", "init");
    this.fO.invalidate();
    this.nnU = new ArrayList();
    Iterator localIterator = SubCoreLocation.fUC().Px(this.lLV).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.nnU.add(str);
    }
    xV(false);
    AppMethodBeat.o(55924);
  }
  
  final void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(55925);
    this.mHandler.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(this.nnU.size());
    Log.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[] { Integer.valueOf(this.nnU.size()), Boolean.valueOf(paramBoolean) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */