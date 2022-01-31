package com.tencent.mm.permission;

import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.jr;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String bwK;
  static final String bwL;
  static Map<Integer, a> eQL;
  c eQM = new a.1(this);
  private c eQN = new a.2(this);
  private c eQO = new c() {};
  
  static
  {
    Object localObject = q.zg();
    bwK = (String)localObject;
    bwL = o.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    eQL = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a(38, 40, 41, R.l.app_permission_tips_title_record, R.l.app_permission_tips_content_prefix_audio));
    eQL.put(Integer.valueOf(2), new a(43, 44, 45, R.l.app_permission_tips_title_camera, R.l.app_permission_tips_content_prefix_camera));
  }
  
  public a()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.eQM);
    com.tencent.mm.sdk.b.a.udP.c(this.eQN);
    com.tencent.mm.sdk.b.a.udP.c(this.eQO);
  }
  
  private static int oX(String paramString)
  {
    try
    {
      int i = bk.getInt(g.AA().getValue(paramString), 0);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + paramString);
    }
    return 0;
  }
  
  private static final class a
  {
    public int eQQ;
    public int eQR;
    public int eQS;
    public int eQT;
    public int eQU;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.eQQ = paramInt1;
      this.eQR = paramInt2;
      this.eQS = paramInt3;
      this.eQT = paramInt4;
      this.eQU = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */