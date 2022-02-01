package com.tencent.mm.mj_template.api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/api/IMaasUserPermissoinChecker;", "", "checkPermission", "", "scene", "", "hasRequested", "requestPermission", "", "context", "Landroid/content/Context;", "resultOk", "Lkotlin/Function0;", "resultFail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isCancel", "Companion", "plugin-mj-template.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final c.a nZm = c.a.nZn;
  
  public abstract boolean HC(String paramString);
  
  public abstract boolean HD(String paramString);
  
  public abstract void a(String paramString, Context paramContext, a<ah> parama, b<? super Boolean, ah> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.mj_template.api.c
 * JD-Core Version:    0.7.0.1
 */