package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.b.a.c;
import com.google.b.b.a.f;
import java.util.List;

abstract interface am
{
  public abstract f<Void> F(String paramString);
  
  public abstract int a(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  
  public abstract int a(List<CaptureRequest> paramList, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  
  public abstract void close();
  
  public abstract void gG();
  
  public abstract CameraDevice hC();
  
  public abstract a hD();
  
  public abstract c hE();
  
  public abstract void hF();
  
  public abstract void hG();
  
  public static abstract class a
  {
    void a(am paramam) {}
    
    void a(am paramam, Surface paramSurface) {}
    
    void b(am paramam) {}
    
    void c(am paramam) {}
    
    void d(am paramam) {}
    
    void g(am paramam) {}
    
    void h(am paramam) {}
    
    void i(am paramam) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.am
 * JD-Core Version:    0.7.0.1
 */