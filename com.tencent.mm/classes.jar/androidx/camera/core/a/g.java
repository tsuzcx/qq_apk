package androidx.camera.core.a;

import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ba;
import java.util.concurrent.Executor;

public abstract interface g
  extends ba
{
  public static final ac.a<Executor> Qp = ac.a.a("camerax.core.thread.backgroundExecutor", Executor.class, null);
  
  public abstract Executor d(Executor paramExecutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.g
 * JD-Core Version:    0.7.0.1
 */