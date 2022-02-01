import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;

class fxv
  extends IAIOImageProviderCallBack.Stub
{
  fxv(fxu paramfxu) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new fxx(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new fxw(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    this.a.a.runOnUiThread(new fxy(this, paramArrayOfAIOImageData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxv
 * JD-Core Version:    0.7.0.1
 */