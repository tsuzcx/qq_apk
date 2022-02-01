package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import java.util.ArrayList;

public abstract interface n
  extends a
{
  public abstract void a(Intent paramIntent, ebn paramebn, int paramInt);
  
  public abstract void a(Intent paramIntent, ebp paramebp, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean go(String paramString);
  
  public abstract ArrayList<String> gp(String paramString);
  
  public abstract boolean gq(String paramString);
  
  public abstract String gr(String paramString);
  
  public abstract String gs(String paramString);
  
  public abstract void gt(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.n
 * JD-Core Version:    0.7.0.1
 */