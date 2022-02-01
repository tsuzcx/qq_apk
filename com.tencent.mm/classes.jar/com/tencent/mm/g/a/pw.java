package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bo;
import java.util.List;

public final class pw
  extends b
{
  public a dsN;
  public b dsO;
  
  public pw()
  {
    this((byte)0);
  }
  
  private pw(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.dsN = new a();
    this.dsO = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public String dhD;
    public agx dhe;
    public bo dpq;
    public String dsP;
    public ahn dsQ;
    public int dsR = 0;
    public List<bo> dsS;
    public String dsT;
    public String dsU;
    public d dsV;
    public boolean dsW = false;
    public cs dsm;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public d dsV;
    public c dsX;
    public String dsY;
    public boolean dsZ = false;
    public cs dsm;
    public boolean dta = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.pw
 * JD-Core Version:    0.7.0.1
 */