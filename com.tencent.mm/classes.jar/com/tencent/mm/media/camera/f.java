package com.tencent.mm.media.camera;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/ICameraCoroutines;", "Ljava/util/concurrent/Executor;", "cameraAsync", "Lkotlinx/coroutines/Deferred;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "cameraLaunch", "Lkotlinx/coroutines/Job;", "", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
  extends Executor
{
  public abstract cb f(m<? super aq, ? super d<? super ah>, ? extends Object> paramm);
  
  public abstract <T> ay<T> g(m<? super aq, ? super d<? super T>, ? extends Object> paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.f
 * JD-Core Version:    0.7.0.1
 */