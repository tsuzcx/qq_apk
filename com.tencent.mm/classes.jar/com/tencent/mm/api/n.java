package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import java.util.ArrayList;

public abstract interface n
  extends a
{
  public abstract void a(Intent paramIntent, drr paramdrr, int paramInt);
  
  public abstract void a(Intent paramIntent, drt paramdrt, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean fD(String paramString);
  
  public abstract ArrayList<String> fE(String paramString);
  
  public abstract boolean fF(String paramString);
  
  public abstract String fG(String paramString);
  
  public abstract String fH(String paramString);
  
  public abstract void fI(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.n
 * JD-Core Version:    0.7.0.1
 */