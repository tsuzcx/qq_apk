package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ad.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static final ak handler;
  private static final String mBC;
  private static final Pattern mBD;
  public String gGm;
  public l hrL;
  public boolean mBE;
  public CharSequence mBF;
  public CharSequence mBG;
  public CharSequence mBH;
  public String mBI;
  public int mBJ;
  private a.b mBK;
  a mBL;
  
  static
  {
    AppMethodBeat.i(74498);
    mBC = ah.getContext().getString(2131300231);
    mBD = Pattern.compile("['\r\n' | '\n']+");
    handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(74498);
  }
  
  public a(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(74493);
    this.mBK = new a.b(this);
    this.mBL = new a();
    AppMethodBeat.o(74493);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(74492);
    if (m.a(paramCharSequence1, paramTextView1))
    {
      if (m.a(paramCharSequence2, paramTextView2))
      {
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(1);
        AppMethodBeat.o(74492);
        return;
      }
      paramTextView1.setMaxLines(2);
      AppMethodBeat.o(74492);
      return;
    }
    if (m.a(paramCharSequence2, paramTextView2)) {
      paramTextView2.setMaxLines(2);
    }
    AppMethodBeat.o(74492);
  }
  
  private static String b(Context paramContext, ad paramad)
  {
    AppMethodBeat.i(74496);
    String str2 = paramad.field_conRemark;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = paramad.field_nickname;
    }
    paramad = str1;
    if (bo.isNullOrNil(str1)) {
      paramad = paramContext.getString(2131300208);
    }
    AppMethodBeat.o(74496);
    return paramad;
  }
  
  private static String b(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(74495);
    if ((paramBoolean) && (!bo.isNullOrNil(paramad.field_conRemark))) {}
    for (String str1 = paramad.field_conRemark;; str1 = paramad.field_nickname)
    {
      String str2 = str1;
      if (bo.isNullOrNil(str1)) {
        str2 = paramad.field_username;
      }
      AppMethodBeat.o(74495);
      return str2;
    }
  }
  
  private String bO(List<String> paramList)
  {
    AppMethodBeat.i(74497);
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = this.mRX.mSy;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (com.tencent.mm.plugin.fts.a.d.Pa(str2).contains(str1))
        {
          localStringBuffer.append(str2);
          localStringBuffer.append(",");
        }
      }
      i += 1;
    }
    localStringBuffer.trimToSize();
    if (localStringBuffer.length() == 0)
    {
      AppMethodBeat.o(74497);
      return "";
    }
    paramList = localStringBuffer.substring(0, localStringBuffer.length() - 1);
    AppMethodBeat.o(74497);
    return paramList;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b Pr()
  {
    return this.mBK;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(74494);
    super.a(paramContext, parama, paramVarArgs);
    long l = this.hrL.mSZ;
    parama = new gi();
    parama.cuX.type = 9;
    parama.cuX.cpM = l;
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    acf localacf = parama.cuY.cvj;
    l = this.hrL.mSZ;
    parama = new gi();
    parama.cuX.type = 11;
    parama.cuX.cpM = l;
    parama.cuX.handler = handler;
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    this.mBI = bo.bf(parama.cuY.thumbPath, "");
    this.gGm = bo.bf(parama.cuY.thumbUrl, "");
    Object localObject = this.hrL;
    float f = b.a.mVP * 2;
    paramVarArgs = localacf.cEC;
    parama = "";
    label262:
    label304:
    int i;
    switch (localacf.type)
    {
    case 5: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      parama = localacf.title;
      switch (((l)localObject).mRU)
      {
      default: 
        this.mBF = parama;
        paramVarArgs = this.hrL;
        localObject = localacf.cEC;
        parama = "";
        switch (localacf.type)
        {
        case 3: 
        case 4: 
        case 8: 
        case 9: 
        case 13: 
        default: 
          parama = "";
          label403:
          switch (paramVarArgs.mRU)
          {
          default: 
            paramVarArgs = "";
            i = -1;
            label454:
            if ((i == -1) || (bo.isNullOrNil(parama))) {}
            break;
          }
          break;
        }
        break;
      }
      break;
    }
    for (parama = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(i), paramVarArgs });; parama = paramVarArgs)
    {
      this.mBG = parama;
      l locall = this.hrL;
      paramVarArgs = localacf.czp;
      parama = localacf.wUL;
      if (bo.isNullOrNil(paramVarArgs))
      {
        localObject = null;
        paramVarArgs = parama;
        parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      }
      for (;;)
      {
        if (bo.isNullOrNil(paramVarArgs)) {}
        label601:
        ad localad;
        label1289:
        boolean bool3;
        label1341:
        label1378:
        for (paramContext = new SpannableString("");; paramContext = TextUtils.concat(new CharSequence[] { paramContext.getResources().getString(2131302979), parama }))
        {
          this.mBH = paramContext;
          switch (localacf.type)
          {
          case 7: 
          default: 
            i = 2131231371;
            this.mBJ = i;
            AppMethodBeat.o(74494);
            return;
            parama = mBD.matcher(localacf.desc).replaceAll(" ");
            break label262;
            parama = paramContext.getResources().getString(2131303006);
            break label262;
            parama = localacf.cEC.wUd;
            if ((mBC.equals(parama.cDl)) || (bo.isNullOrNil(parama.cDl)))
            {
              parama = parama.label;
              break label262;
            }
            parama = parama.cDl;
            break label262;
            parama = paramContext.getResources().getString(2131303010);
            break label262;
            parama = paramContext.getResources().getString(2131303011);
            break label262;
            if (paramVarArgs.wUh == null) {
              break label262;
            }
            parama = paramVarArgs.wUh.title;
            break label262;
            parama = new StringBuffer();
            paramVarArgs = paramVarArgs.wVc.iterator();
            while (paramVarArgs.hasNext())
            {
              str = b.a((aca)paramVarArgs.next());
              if (!bo.isNullOrNil(str))
              {
                parama.append(str);
                parama.append(" ");
              }
            }
            paramVarArgs = mBD.matcher(parama.toString()).replaceAll(" ");
            parama = paramVarArgs;
            if (!bo.isNullOrNil(paramVarArgs)) {
              break label262;
            }
            parama = paramContext.getResources().getString(2131303008);
            break label262;
            paramVarArgs = localacf.title;
            parama = paramVarArgs;
            if (bo.isNullOrNil(localacf.desc)) {
              break label262;
            }
            parama = paramVarArgs + "-" + localacf.desc;
            break label262;
            parama = paramContext.getResources().getString(2131303009);
            break label262;
            parama = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mRX, f, b.c.mVY)).mSp;
            break label304;
            if (bo.isNullOrNil(localacf.appId)) {
              break label403;
            }
            parama = ad.a.flG.t(paramContext, localacf.appId);
            break label403;
            parama = localacf.title;
            break label403;
            parama = localacf.cEC.wUd;
            if ((mBC.equals(parama.cDl)) || (bo.isNullOrNil(parama.cDl)))
            {
              parama = parama.label;
              break label403;
            }
            parama = parama.cDl;
            break label403;
            if (((acq)localObject).wUh == null) {
              break label403;
            }
            parama = ((acq)localObject).wUh.desc;
            break label403;
            parama = "";
            break label403;
            i = 2131303005;
            paramVarArgs = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mRX)).mSp;
            break label454;
            i = 2131303007;
            parama = bO(localacf.wUM);
            paramVarArgs = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mRX)).mSp;
            break label454;
            paramVarArgs = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mRX)).mSp;
            i = -1;
            break label454;
            localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramVarArgs);
            localad.setUsername(paramVarArgs);
            String str = null;
            localObject = str;
            if (t.lA(paramVarArgs))
            {
              localObject = str;
              if (!bo.isNullOrNil(parama))
              {
                localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parama);
                ((ad)localObject).setUsername(parama);
              }
            }
            switch (locall.mRU)
            {
            case 15: 
            case 19: 
            default: 
              bool2 = false;
              bool1 = false;
              i = 0;
              if (localObject == null) {
                break label1644;
              }
              parama = b((ad)localObject, true) + "-" + b(paramContext, localad);
              bool3 = bool2;
              bool2 = bool1;
              bool1 = bool3;
              parama = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427758));
              if (i == 0) {
                break label1782;
              }
              parama = f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mRX, bool2, bool1)).mSp;
            }
            break;
          }
        }
        boolean bool2 = true;
        label1409:
        for (boolean bool1 = true;; bool1 = false)
        {
          if (localObject != null)
          {
            parama = b((ad)localObject, false) + "-" + b(paramContext, localad);
            bool3 = bool1;
            i = 1;
            bool1 = bool2;
            bool2 = bool3;
            break label1341;
          }
          parama = b(localad, false);
          bool3 = bool1;
          i = 1;
          bool1 = bool2;
          bool2 = bool3;
          break label1341;
          bool1 = true;
          label1498:
          for (bool2 = true;; bool2 = false)
          {
            if (localObject != null) {
              parama = b((ad)localObject, true) + "-" + b(paramContext, localad);
            }
            for (;;)
            {
              paramVarArgs = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(localacf.cmx);
              parama = parama + "-" + b(paramVarArgs, true);
              i = 1;
              break;
              if (t.lA(localad.field_username)) {
                parama = b(paramContext, localad);
              } else {
                parama = b(localad, true);
              }
            }
            bool2 = true;
            label1635:
            for (bool1 = true;; bool1 = false)
            {
              i = 1;
              break label1289;
              label1644:
              if (t.lA(localad.field_username))
              {
                parama = b(paramContext, localad);
                bool3 = bool1;
                bool1 = bool2;
                bool2 = bool3;
                break label1341;
              }
              parama = b(localad, true);
              bool3 = bool1;
              bool1 = bool2;
              bool2 = bool3;
              break label1341;
              if ((localacf.cEC.wVc == null) || (localacf.cEC.wVc.size() <= 0)) {
                break;
              }
              i = com.tencent.mm.pluginsdk.d.akU(((aca)localacf.cEC.wVc.get(0)).wSR);
              break label601;
              i = 2131230829;
              break label601;
              i = 2131230828;
              break label601;
              i = 2131230826;
              break label601;
              i = 2131230807;
              break label601;
              label1782:
              break label1378;
              bool2 = false;
              break label1409;
              bool1 = false;
              break label1498;
              bool2 = false;
              break label1635;
              bool2 = false;
            }
            bool1 = false;
          }
          bool2 = false;
        }
      }
    }
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public TextView gpL;
    public View gqg;
    public MMImageView mBM;
    public TextView mBN;
    public TextView mBO;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a
 * JD-Core Version:    0.7.0.1
 */